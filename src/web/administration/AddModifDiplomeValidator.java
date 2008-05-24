package web.administration;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.Diplome;

public class AddModifDiplomeValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return Diplome.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		/* Verifie que les champs sont remplis */
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "denomination", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "etablissement", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "annee", "field.required", "Ne doit pas �tre vide");
	}
}
