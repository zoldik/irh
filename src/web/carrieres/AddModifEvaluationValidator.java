package web.carrieres;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import entities.Evaluation;

public class AddModifEvaluationValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return Evaluation.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		/* Verifie que les champs sont remplis */
		// Champs dateEvaluation
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dateEvaluation", "field.required", "Ne doit pas etre vide");
	}
}
