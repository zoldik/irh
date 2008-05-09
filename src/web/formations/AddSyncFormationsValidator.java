package web.formations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import entities.TextFileUploadBean;

public class AddSyncFormationsValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return TextFileUploadBean.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		/* Verifie que les champs sont remplis */
		// Champs file
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "file", "field.required", "Ne doit pas etre vide");
	}
}
