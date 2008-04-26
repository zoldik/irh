package web.consultation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import services.IServiceUtilisateur;

import entities.Utilisateur;

public class IdentificationValidator implements Validator {

	private IServiceUtilisateur su;
	
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
		// Champs password
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "pass", "field.required", "Ne doit pas être vide");
		
		/* Si pas d'erreur de saisie, on verifie que le login 
		 * et le mot de passe sont correct
		 */
		if(!arg1.hasErrors())
		{
			if(!su.existeUtilisateur(user))
			{
				arg1.rejectValue("login", "bad.user", "Login ou password incorrect");
			}
		}
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}

}
