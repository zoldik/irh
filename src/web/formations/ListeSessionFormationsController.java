package web.formations;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.SessionFormation;

import services.IServiceSessionFormation;

public class ListeSessionFormationsController implements Controller {

	private IServiceSessionFormation ssf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'id du plan de formation
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(arg0.getParameter("id")); }
    	catch (Exception e) { e.printStackTrace(); }
    	
    	// Recupere la liste et selectionne celle qui correspond au plan
    	List<SessionFormation> session_formations = new ArrayList<SessionFormation>();
    	if(idPlanFormation != -1)
    	{	
			for (SessionFormation sessionFormation : ssf.listSessionFormations()) {
				if(sessionFormation.getPlanFormation().getId() == idPlanFormation)
					session_formations.add(sessionFormation);
			}
    	}
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_session_formations");
		myModelAndView.addObject("session_formations", session_formations);
 
		return myModelAndView;
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}
}
