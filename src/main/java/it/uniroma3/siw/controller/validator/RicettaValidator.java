package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Ricetta;
import it.uniroma3.siw.repository.RicettaRepository;

@Component
public class RicettaValidator implements Validator {
	@Autowired
	private RicettaRepository RicettaRepository;

	@Override
	public void validate(Object o, Errors errors) {
		Ricetta Ricetta = (Ricetta)o;
		if (Ricetta.getNome()!=null 
				&& RicettaRepository.existsByNome(Ricetta.getNome())) {
			errors.reject("Ricetta.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Ricetta.class.equals(aClass);
	}
}