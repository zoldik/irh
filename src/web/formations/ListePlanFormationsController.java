package web.formations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.PlanFormation;

import services.IServicePlanFormation;

public class ListePlanFormationsController implements Controller {

	private IServicePlanFormation spf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<PlanFormation> plan_formations = spf.listPlanFormations();
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
}
