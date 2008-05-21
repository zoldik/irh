package web.formations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import entities.SessionFormation;

public class AddModifSessionFormationValidator implements Validator {
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return SessionFormation.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		//SessionFormation session = (SessionFormation)arg0;
		/* Verifie que les champs sont remplis */
		// Champs dateDebut
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateDebut", "field.required", "Ne doit pas etre vide");
		// Champs dateFin
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateFin", "field.required", "Ne doit pas etre vide");
	}
}
