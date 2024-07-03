package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.controller.validator.CuocoValidator;
import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.service.CuocoService;
import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CuocoController {
	@Autowired 
	private CuocoService cuocoService;
	@Autowired
	private CuocoValidator cuocoValidator;
	@Autowired
	private CredentialsService credentialsService;
	
	@GetMapping(value="/admin/formNewCuoco")
	public String formNewCuoco(Model model) {
		model.addAttribute("cuoco", new Cuoco());
		return "admin/formNewCuoco.html";
	}
	
	@GetMapping(value="/admin/manageCuoco")
	public String manageCuoco(Model model) {
		model.addAttribute("cuochi", this.cuocoService.getAllCuochi());
		return "admin/manageCuoco.html";
	}
	
	@GetMapping(value="/admin/indexCuoco")
	public String indexCuoco() {
		return "admin/indexCuoco.html";
	}
	
	@PostMapping("/admin/cuoco")
	public String newCuoco(@Valid @ModelAttribute("cuoco") Cuoco cuoco, BindingResult bindingResult, Model model) {
		this.cuocoValidator.validate(cuoco, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.cuocoService.saveCuoco(cuoco);
			model.addAttribute("cuoco", cuoco);
			return "cuoco.html";
		} else {
			return "admin/formNewCuoco.html"; 
		}
	}

	@GetMapping("/cuoco/{id}")
	public String getCuoco(@PathVariable("id") Long id, Model model) {
		Cuoco cuoco = cuocoService.getCuoco(id);
		model.addAttribute("cuoco", cuoco);

		// Aggiungi l'ID del cuoco autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		Cuoco authenticatedCuoco = credentials.getCuoco();
		model.addAttribute("authenticatedCuocoId", authenticatedCuoco.getId());

		return "cuoco";
	}


	@GetMapping("/cuochi")
	public String getCuochi(Model model) {
		List<Cuoco> cuochi = cuocoService.getAllCuochi();
		model.addAttribute("cuochi", cuochi);
		return "cuochi";
	}


	@PostMapping("/admin/cuoco/{id}/delete")
	public String deleteCuoco(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		// Ottenere le credenziali dell'utente autenticato
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Credentials credentials = credentialsService.getCredentials(username);

		// Ottenere il cuoco da eliminare
		Cuoco cuocoToDelete = cuocoService.getCuoco(id);

		// Verifica se l'utente autenticato sta tentando di eliminare il suo stesso cuoco
		if (credentials.getCuoco() != null && credentials.getCuoco().getId().equals(cuocoToDelete.getId())) {
			redirectAttributes.addFlashAttribute("error", "Non puoi eliminare te stesso!");
			redirectAttributes.addFlashAttribute("cuocoId", id);
			return "redirect:/admin/manageCuoco"; // Reindirizza con parametro error
		}

		// Esegui l'eliminazione diretta del cuoco
		cuocoService.deleteById(id);
		return "redirect:/admin/manageCuoco"; // Reindirizza alla pagina di gestione dei cuochi dopo l'eliminazione
	}

	/*chef*/
	@GetMapping(value="/chef/indexUser")
	public String indexUser() {
		return "chef/indexUser.html";
	}

}
