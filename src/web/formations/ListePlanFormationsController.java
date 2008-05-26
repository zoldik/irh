package web.formations;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Inscription;
import entities.PlanFormation;
import entities.SessionFormation;

import services.IServiceInscription;
import services.IServicePlanFormation;

public class ListePlanFormationsController implements Controller {

	private IServicePlanFormation spf;
	private IServiceInscription si;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<PlanFormation> plan_formations = spf.listPlanFormations();
		for (PlanFormation planFormation : plan_formations) {
			double budgetTotal = 0;
			double prixTotal = 0;
			double volumeHoraire = 0;			
			// Parcours des sessions
			Set<SessionFormation> sessions = planFormation.getSessionFormationCollection();
			for (SessionFormation sessionFormation : sessions) {
				// Calcul le volume horaire global
				volumeHoraire += sessionFormation.getFormation().getDuree();
				
				// Calcul du prixTotal pour une session
				int nbParticipants = 0;
				for (Inscription i : si.listInscriptions()) {
					if(i.getPk().getIdSessionFormation() == sessionFormation.getId())
						nbParticipants++;
				}
				prixTotal = sessionFormation.getFormation().getPrixParPersonne() * nbParticipants;
				
				budgetTotal += prixTotal;
			}
			planFormation.setVolumeHoraire(volumeHoraire);
			planFormation.setBudgetTotal(budgetTotal);
		}
		
		
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_plan_formations");
		myModelAndView.addObject("plan_formations", plan_formations);
 
		return myModelAndView;
	}

	public IServicePlanFormation getSpf() {
		return spf;
	}

	public void setSpf(IServicePlanFormation spf) {
		this.spf = spf;
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}
}
