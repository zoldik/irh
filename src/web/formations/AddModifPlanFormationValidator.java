package web.formations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import services.IServicePlanFormation;

import entities.PlanFormation;

public class AddModifPlanFormationValidator implements Validator {

	private IServicePlanFormation spf;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return PlanFormation.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		PlanFormation plan = (PlanFormation)arg0;
		/* Verifie que les champs sont remplis */
		// Champs annee
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "annee", "field.required", "Ne doit pas etre vide");

		// Si pas d'erreur de saisie, on verifie que l'annee n'existe pas deja
		if(!arg1.hasErrors())
		{
			boolean anneePresente = false;
			for (PlanFormation a : spf.listPlanFormations())
			{
				if(a.getAnnee() == plan.getAnnee())
					anneePresente = true;
			}
			if(anneePresente)
			{
				arg1.rejectValue("annee", "bad.year", "Annee deja existante");
			}
		}
	}

	public IServicePlanFormation getSpf() {
		return spf;
	}

	public void setSpf(IServicePlanFormation spf) {
		this.spf = spf;
	}
}
