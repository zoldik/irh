package web.administration;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import entities.Utilisateur;

public class AddModifUtilisateurValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return Utilisateur.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Utilisateur user = (Utilisateur)arg0;
		
		/* Verifie que les champs sont remplis */
		// Champs login
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "login", "field.required", "Ne doit pas être vide");
		// Champs nom
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nom", "field.required", "Ne doit pas être vide");
		// Champs password
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "pass", "field.required", "Ne doit pas être vide");
		// Champs confirmation
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "confirmation", "field.required", "Ne doit pas être vide");
		
		/* Si pas d'erreur de saisie, on verifie que le password 
		 * et la confirmation sont identique.
		 */
		if(!arg1.hasErrors())
		{
			if(!(user.getPass()).equals(user.getConfirmation()))
			{
				arg1.rejectValue("pass", "bad.password", "Les champs Password et Confirmation sont différents");
			}
		}
	}
}
