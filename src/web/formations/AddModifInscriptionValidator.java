package web.formations;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import services.IServiceInscription;

import entities.Inscription;

public class AddModifInscriptionValidator implements Validator {
	
	private IServiceInscription si;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class arg0) {
		return Inscription.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Inscription inscription = (Inscription)arg0;
		
		// On verifie que l'employe n'est pas deja inscrit
		boolean employeInscrit = false;
		for (Inscription i : si.listInscriptions())
		{
			if((i.getPk().getIdEmploye() == inscription.getEmploye().getId()) &&
				(i.getPk().getIdSessionFormation() == inscription.getSessionFormation().getId())
				)
				employeInscrit = true;
		}
		if(employeInscrit)
		{
			arg1.rejectValue("employe", "already.subcribe", "Employe deja inscrit");
		}
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}
}
