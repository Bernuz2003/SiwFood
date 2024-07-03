package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.CuocoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;


@Controller
public class AuthenticationController {
	
	@Autowired
	private CredentialsService credentialsService;
    @Autowired
	private CuocoService cuocoService;
	
	@GetMapping(value = "/register") 
	public String showRegisterForm (Model model) {
		model.addAttribute("user", new Cuoco());
		model.addAttribute("credentials", new Credentials());
		return "formRegisterUser";
	}
	
	@GetMapping(value = "/login") 
	public String showLoginForm (Model model) {
		return "formLogin";
	}

	@GetMapping(value = "/") 
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
	        return "index.html";
		}
		else {		
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
			if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
				return "admin/indexAdmin.html";
			}
		}
        return "index.html";
	}
		
    @GetMapping(value = "/success")
    public String defaultAfterLogin(Model model) {
        
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());

		Cuoco cuoco = credentials.getCuoco();

		if (cuoco != null) {
			cuoco = cuocoService.getCuoco(cuoco.getId());
			model.addAttribute("cuoco", cuoco);
		}

    	if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
            return "admin/indexAdmin.html";
        }
        return "user/indexUser.html";
    }


	@PostMapping(value = { "/register" })
	public String registerUser(@Valid @ModelAttribute("user") Cuoco user,
							   BindingResult userBindingResult, @Valid
							   @ModelAttribute("credentials") Credentials credentials,
							   BindingResult credentialsBindingResult,
							   @RequestParam("immagine") MultipartFile immagine,
							   Model model) {

		// se user e credential hanno entrambi contenuti validi, memorizza User e the Credentials nel DB
		if(!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			try {
				String immagineFileName = saveImage(immagine);
				user.setImagePath(immagineFileName);

				cuocoService.saveCuoco(user);
				credentials.setCuoco(user);
				credentialsService.saveCredentials(credentials);
				model.addAttribute("user", user);
				return "redirect:/login";
			} catch (IOException e) {
				model.addAttribute("error", "Errore durante il caricamento dell'immagine: " + e.getMessage());
				return "formRegisterUser";
			}
		}
		return "formRegisterUser";
	}

	private String saveImage(MultipartFile immagine) throws IOException {
		String immagineFileName = System.currentTimeMillis() + "_" + immagine.getOriginalFilename(); // Assicurati che il nome del file sia unico
		Path uploadPath = Paths.get("src/main/resources/static/images/cuochi"); // Percorso assoluto

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
			System.out.println("Created directories: " + uploadPath.toString());
		}

		Path imageFilePath = uploadPath.resolve(immagineFileName);
		Files.write(imageFilePath, immagine.getBytes());
		System.out.println("Image saved at: " + imageFilePath.toString());

		return immagineFileName;
	}


}