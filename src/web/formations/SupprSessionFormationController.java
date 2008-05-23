package web.formations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.SessionFormation;

import services.IServiceSessionFormation;

public class SupprSessionFormationController implements Controller {

	private IServiceSessionFormation ssf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'id a supprimer
		SessionFormation session = new SessionFormation();
		
		int id = -1;
		try { id = Integer.parseInt(arg0.getParameter("id")); }
		catch (Exception e) { e.printStackTrace(); }
		session.setId(id);
		// Supprime
		ssf.deleteSessionFormation(session);
		// Redirige vers la liste des session de formation
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		
		//Recupere l'id du plan de formation pour la redirection
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(arg0.getParameter("id_plan_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		arg1.sendRedirect("liste_session_formations.htm?id=" + idPlanFormation);
		
		return null;
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}

}
