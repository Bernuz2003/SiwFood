package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.controller.validator.IngredienteValidator;
import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.service.IngredienteService;
import jakarta.validation.Valid;

@Controller
public class IngredienteController {
	@Autowired 
	private IngredienteService ingredienteService;
	@Autowired
	private IngredienteValidator ingredienteValidator;
	
	
	@GetMapping("/user/formNewIngrediente")
	public String formNewIngrediente(@RequestParam(value = "source", required = false) String source,
	                                 @RequestParam(value = "ricettaId", required = false) Long ricettaId, Model model) {
	    model.addAttribute("source", source);
	    model.addAttribute("ricettaId", ricettaId);
	    model.addAttribute("ingrediente", new Ingrediente());
	    return "user/formNewIngrediente.html";
	}
	
	@GetMapping("/admin/manageIngrediente")
	public String manageIngrediente(Model model) {
		model.addAttribute("ingredienti", this.ingredienteService.findAll());
		return "admin/manageIngrediente.html";
	}
	
	@GetMapping("admin/indexIngrediente")
	public String indexIngrediente() {
		return "admin/indexIngrediente.html";
	}
	
	@PostMapping("/user/ingrediente")
	public String newIngrediente(@RequestParam("source") String source,
	                             @RequestParam(value = "ricettaId", required = false) Long ricettaId,
	                             @Valid @ModelAttribute("ingrediente") Ingrediente ingrediente,
	                             BindingResult bindingResult, Model model) {
	    this.ingredienteValidator.validate(ingrediente, bindingResult);
	    if (!bindingResult.hasErrors()) {
	        this.ingredienteService.save(ingrediente);
	        if ("ingredientiToAdd".equals(source) && ricettaId != null) {
				return "redirect:/user/updateIngredienti/" + ricettaId;
	        } else {
	            return "admin/indexAdmin.html"; // pagina di default
	        }
	    } else {
	        model.addAttribute("ingrediente", ingrediente);
	        model.addAttribute("source", source);
	        model.addAttribute("ricettaId", ricettaId);
	        return "user/formNewIngrediente.html";
	    }
	}

	
	@PostMapping("/admin/ingrediente/{id}/delete")
    public String deleteIngrediente(@PathVariable("id") Long id, Model model) {
        Ingrediente ingrediente = ingredienteService.findById(id);
        if (ingrediente != null) {
            ingredienteService.deleteById(id);
            return "redirect:/admin/manageIngrediente";
        } else {
            model.addAttribute("messaggioErrore", "Ingrediente non trovato");
            return "admin/indexIngrediente.html";
            }
        }
	
}
