package it.prova.pokeronline.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.prova.pokeronline.dto.UtenteDTO;

public class UtenteValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return UtenteDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required", "Campo obbligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required", "Campo obbligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "Campo obbligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Campo obbligatorio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataRegistrazione", "required", "Campo obbligatorio.");
		

	}

}
