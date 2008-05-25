package web.formations;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Inscription;

import services.IServiceInscription;

public class ListeInscriptionsController implements Controller {

	private IServiceInscription si;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'id du plan de formation
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(arg0.getParameter("id_plan_formation")); }
    	catch (Exception e) { e.printStackTrace(); }
    	
		// Recupere l'id de la session de formation
		int idSessionFormation = -1;
		try { idSessionFormation = Integer.parseInt(arg0.getParameter("id_session_formation")); }
    	catch (Exception e) { e.printStackTrace(); }
    	
    	// Recupere la liste et selectionne celle qui correspond au plan
    	List<Inscription> inscriptions = new ArrayList<Inscription>();
    	if(idSessionFormation != -1)
    	{	
			for (Inscription inscription : si.listInscriptions()) {
				if(inscription.getPk().getIdSessionFormation() == idSessionFormation)
					inscriptions.add(inscription);
			}
    	}
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_inscriptions");
		myModelAndView.addObject("inscriptions", inscriptions);
		myModelAndView.addObject("id_session_formation", idSessionFormation);
		myModelAndView.addObject("id_plan_formation", idPlanFormation);
 
		return myModelAndView;
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}
}
