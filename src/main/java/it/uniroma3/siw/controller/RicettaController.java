package it.uniroma3.siw.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.controller.validator.RicettaValidator;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.service.CuocoService;
import it.uniroma3.siw.service.IngredienteService;
import it.uniroma3.siw.service.RicettaService;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RicettaController {
	@Autowired
	private RicettaService ricettaService;
	@Autowired
	private CuocoService cuocoService;
	@Autowired
	private IngredienteService ingredienteService;
	@Autowired
	private CredentialsService credentialsService;
	@Autowired
	private RicettaValidator ricettaValidator;

	@GetMapping("/admin/indexRicetta")
	public String indexRicetta() {
		return "admin/indexRicetta.html";
	}

	@GetMapping("/admin/manageRicetta")
	public String manageRicetta(Model model) {
		model.addAttribute("ricette", this.ricettaService.findAll());
		return "admin/manageRicetta.html";
	}

	@GetMapping("/admin/setCuocoToRicetta/{cuocoId}/{ricettaId}")
	public String setCuocoToricetta(@PathVariable("cuocoId") Long cuocoId, @PathVariable("ricettaId") Long ricettaId,
			Model model) {

		Cuoco cuoco = this.cuocoService.getCuoco(cuocoId);
		Ricetta ricetta = this.ricettaService.findById(ricettaId);
		ricetta.setCuoco(cuoco);
		this.ricettaService.save(ricetta);
		model.addAttribute("cuochi", cuocoService.getAllCuochi());
		model.addAttribute("ricetta", ricetta);
		return "user/formUpdateRicetta.html";
	}

	@GetMapping(value = "/user/formNewRicetta")
	public String formNewRicetta(Model model) {
		model.addAttribute("ricetta", new Ricetta());
		return "user/formNewRicetta.html";
	}

	@GetMapping("/user/formUpdateRicetta/{id}")
	public String formUpdateRicetta(@PathVariable("id") Long id, Model model) {
		Ricetta ricetta = ricettaService.findById(id);
		List<Ingrediente> ingredienti = ricetta.getIngredienti();
		List<Cuoco> cuochi = cuocoService.getAllCuochi();
		
		model.addAttribute("ricetta", ricetta);
		model.addAttribute("cuochi", cuochi);
		model.addAttribute("ingredienti", ingredienti);
		return "user/formUpdateRicetta.html";
	}

	@GetMapping("/ricetta/{id}")
	public String getRicetta(@PathVariable("id") Long id, Model model) {
		Cuoco cuoco = ricettaService.findById(id).getCuoco();
		model.addAttribute("ricetta", ricettaService.findById(id));
		model.addAttribute("ingredienti", ricettaService.findById(id).getIngredienti());
		model.addAttribute("cuoco", cuoco);
		return "ricetta.html";
	}

	@GetMapping("/ricette")
	public String getRicette(Model model) {
		model.addAttribute("ricette", this.ricettaService.findAll());
		return "ricette.html";
	}


	@GetMapping("/user/updateIngredienti/{id}")
	public String updateIngredienti(@PathVariable("id") Long id,Model model) {

		List<Ingrediente> ingredientiToAdd = this.ingredientiToAdd(id);
		model.addAttribute("ingredientiToAdd", ingredientiToAdd);
		model.addAttribute("ricetta", this.ricettaService.findById(id));
		return "user/ingredientiToAdd.html";
	}


	@PostMapping("/user/saveIngredientiQuantita")
	public String saveIngredientiQuantita(@RequestParam("ricettaId") Long ricettaId,
										  @RequestParam Map<String, String> ingredientiQuantita,
										  Model model) {
		Ricetta ricetta = ricettaService.findById(ricettaId);

		// Aggiorna le quantità degli ingredienti
		for (Ingrediente ingrediente : ricetta.getIngredienti()) {
			String quantitaString = ingredientiQuantita.get("quantita_" + ingrediente.getId());
			if (quantitaString != null && !quantitaString.isEmpty()) {
				int quantita = Integer.parseInt(quantitaString);
				ingrediente.setQuantità(quantita);
				ingredienteService.save(ingrediente);
			}
		}

		ricettaService.save(ricetta);
		model.addAttribute("cuochi", cuocoService.getAllCuochi());

		// Aggiungi l'oggetto ricetta aggiornato al model per renderlo disponibile nella vista
		model.addAttribute("ricetta", ricetta);

		// Reindirizza alla pagina della ricetta appena salvata
		return "redirect:/ricetta/" + ricetta.getId();
	}



	@PostMapping("/user/ricetta")
	public String newRicetta(@Valid @ModelAttribute("ricetta") Ricetta ricetta, BindingResult bindingResult, @RequestParam("immagine") MultipartFile immagine,
							 Model model) throws IOException {
		this.ricettaValidator.validate(ricetta, bindingResult);
		if (!bindingResult.hasErrors()) {
			// Ottenere il cuoco autenticato
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			Credentials credentials = credentialsService.getCredentials(username);
			Cuoco cuoco = credentials.getCuoco();

			String immagineFileName = saveImage(immagine);

			ricetta.setCuoco(cuoco);
			ricetta.setImagePath(immagineFileName);

			Ricetta savedRicetta = this.ricettaService.save(ricetta);
			model.addAttribute("ricetta", savedRicetta);
			return "redirect:/user/updateIngredienti/" + savedRicetta.getId();
		} else {
			return "user/formNewRicetta.html";
		}
	}


	@GetMapping("/user/addIngredienteToRicetta/{ingredienteId}/{ricettaId}")
	public String addIngredienteToRicetta(@PathVariable("ingredienteId") Long ingredienteId,
			@PathVariable("ricettaId") Long ricettaId, Model model) {
		Ricetta ricetta = this.ricettaService.findById(ricettaId);
		Ingrediente ingrediente = this.ingredienteService.findById(ingredienteId);
		List<Ingrediente> ingredienti = ricetta.getIngredienti();
		ingredienti.add(ingrediente);
		this.ricettaService.save(ricetta);

		List<Ingrediente> ingredientiToAdd = ingredientiToAdd(ricettaId);

		model.addAttribute("ricetta", ricetta);
		model.addAttribute("ingredientiToAdd", ingredientiToAdd);

		return "user/ingredientiToAdd.html";
	}

	@GetMapping("/user/removeIngredienteFromRicetta/{ingredienteId}/{ricettaId}")
	public String removeIngredienteFromRicetta(@PathVariable("ingredienteId") Long ingredienteId,
			@PathVariable("ricettaId") Long ricettaId, Model model) {
		Ricetta ricetta = this.ricettaService.findById(ricettaId);
		Ingrediente ingrediente = this.ingredienteService.findById(ingredienteId);
		List<Ingrediente> ingredienti = ricetta.getIngredienti();
		ingredienti.remove(ingrediente);
		this.ricettaService.save(ricetta);

		List<Ingrediente> ingredientiToAdd = ingredientiToAdd(ricettaId);

		model.addAttribute("ricetta", ricetta);
		model.addAttribute("ingredientiToAdd", ingredientiToAdd);

		return "user/ingredientiToAdd.html";
	}

	private List<Ingrediente> ingredientiToAdd(Long ricettaId) {
		List<Ingrediente> ingredientiToAdd = new ArrayList<>();

		for (Ingrediente s : ingredienteService.findIngredientiNotInRicetta(ricettaId)) {
			ingredientiToAdd.add(s);
		}
		return ingredientiToAdd;
	}

	@GetMapping("/admin/ricetta/{id}")
	public String deleteRicetta(@PathVariable("id") Long id, Model model) {
		Ricetta ricetta = ricettaService.findById(id);
		if (ricetta != null) {
			ricettaService.delete(ricetta);
			// Redirect alla pagina dell'indice dei servizi dopo la cancellazione
			return "redirect:/admin/manageRicetta";
		} else {
			// Nel caso in cui il Cuoco non esista
			model.addAttribute("messaggioErrore", "Ricetta non trovata");
			return "admin/indexRicetta.html";
		}
	}

	@PostMapping("/user/deleteRicetta/{id}")
	public String deleteRicetta(@PathVariable("id") Long id) {
		Ricetta ricetta = ricettaService.findById(id);
		if (ricetta != null) {
			ricettaService.delete(ricetta);
		}
		return "redirect:/cuoco/" + ricetta.getCuoco().getId();
	}

	private String saveImage(MultipartFile immagine) throws IOException {
		String immagineFileName = System.currentTimeMillis() + "_" + immagine.getOriginalFilename(); // Assicurati che il nome del file sia unico
		Path uploadPath = Paths.get("src/main/resources/static/images/ricette"); // Percorso assoluto

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
