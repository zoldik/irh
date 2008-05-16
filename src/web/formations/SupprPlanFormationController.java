package web.formations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.PlanFormation;

import services.IServicePlanFormation;

public class SupprPlanFormationController implements Controller {

	private IServicePlanFormation spf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere le theme � supprimer
		PlanFormation plan = new PlanFormation();
		plan.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime
		spf.deletePlanFormation(plan);
		// Redirige vers la liste des utilisateurs
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_plan_formations.htm");
		
		return null;
	}

	public IServicePlanFormation getSpf() {
		return spf;
	}

	public void setSpf(IServicePlanFormation spf) {
		this.spf = spf;
	}
}
