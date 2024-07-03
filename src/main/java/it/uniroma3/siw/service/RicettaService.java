package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.CuocoRepository;
import it.uniroma3.siw.repository.RicettaRepository;
import jakarta.transaction.Transactional;



@Service
public class RicettaService {
	@Autowired
	private RicettaRepository ricettaRepository;
	@Autowired
	private  CuocoRepository cuocoRepository;

	public Ricetta findById(Long id) {
		return ricettaRepository.findById(id).get();
	}	

	public Iterable<Ricetta> findAll() {
		return ricettaRepository.findAll();
	}

	public  Ricetta save(Ricetta Ricetta) {
		// TODO Auto-generated method stub
		return ricettaRepository.save(Ricetta);
	}

	public List<Ricetta> findBynome(String nome) {
		return ricettaRepository.findByNomeContainingIgnoreCase(nome);
	}

	public void delete(Ricetta ricetta) {
		 ricettaRepository.delete(ricetta);
	}
	
}
