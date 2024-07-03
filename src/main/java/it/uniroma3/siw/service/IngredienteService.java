package it.uniroma3.siw.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingrediente;
import it.uniroma3.siw.repository.IngredienteRepository;
import jakarta.transaction.Transactional;



@Service
public class IngredienteService {
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public Ingrediente findById(Long id) {
		return ingredienteRepository.findById(id).get();
	}
	
	public Iterable<Ingrediente> findAll() {
		return ingredienteRepository.findAll();
	}
	
	public Iterable<Ingrediente> findIngredientiNotInRicetta(@Param("id") Long id){
		 return ingredienteRepository.findIngredientiNotInRicetta(id);
	}

	public void save(Ingrediente Ingrediente) {
		// TODO Auto-generated method stub
		ingredienteRepository.save(Ingrediente);
	}

	public boolean existsByNome(String nome) {
		return ingredienteRepository.existsByNome(nome);
	}

	@Transactional
	public void deleteById(Long id) {
		Ingrediente ingrediente = findById(id);
		ingredienteRepository.deleteReferencesInRicettaIngredienti(id);
		ingredienteRepository.delete(ingrediente);
	}
	
}
