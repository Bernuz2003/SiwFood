package it.uniroma3.siw.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.service.CuocoService;
import it.uniroma3.siw.service.RicettaService;

@Controller
public class SearchController {

    @Autowired
    private RicettaService ricettaService;

    @Autowired
    private CuocoService cuocoService;

    @PostMapping("/search")
    public String search(Model model, @RequestParam String nome) {
        List<Ricetta> ricette = ricettaService.findBynome(nome);
        List<Cuoco> cuochi = cuocoService.findByNome(nome);

        model.addAttribute("ricette", ricette);
        model.addAttribute("cuochi", cuochi);
        return "foundResults"; // Assicurati di avere una pagina foundResults.html
    }

    @PostMapping("/searchRicette")
    public String searchRicette(Model model, @RequestParam String nome) {
        List<Ricetta> ricette = ricettaService.findBynome(nome);
        model.addAttribute("ricette", ricette);
        return "foundRicette";
    }

    @PostMapping("/searchCuochi")
    public String searchCuochi(Model model, @RequestParam String nome) {
        List<Cuoco> cuochi = cuocoService.findByNome(nome);
        model.addAttribute("cuochi", cuochi);
        return "foundCuochi";
    }
}
