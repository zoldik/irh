package web.administration;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entities.Employe;

public class AddModifEmployeValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return Employe.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		/* Verifie que les champs sont remplis */
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nom", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "prenom", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateNaissance", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "adrRue", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "adrCp", "field.required", "Ne doit pas �tre vide");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "adrVille", "field.required", "Ne doit pas �tre vide");	
	}
}
