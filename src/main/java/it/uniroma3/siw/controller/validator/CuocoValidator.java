package it.uniroma3.siw.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Cuoco;
import it.uniroma3.siw.repository.CuocoRepository;

@Component
public class CuocoValidator implements Validator {
	@Autowired
	private CuocoRepository CuocoRepository;

	@Override
	public void validate(Object o, Errors errors) {
		Cuoco Cuoco = (Cuoco)o;
		if (Cuoco.getNome()!=null 
				&& CuocoRepository.existsByNomeAndCognome(Cuoco.getNome(), Cuoco.getCognome())) {
			errors.reject("Cuoco.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Cuoco.class.equals(aClass);
	}
}