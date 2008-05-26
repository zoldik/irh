package web.carrieres;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Evaluation;

import services.IServiceEvaluation;

public class ListeEvaluationsController implements Controller {

	private IServiceEvaluation se;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Evaluation> evaluations = se.listEvaluations();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_evaluations");
		myModelAndView.addObject("evaluations", evaluations);
 
		return myModelAndView;
	}

	public IServiceEvaluation getSe() {
		return se;
	}

	public void setSe(IServiceEvaluation se) {
		this.se = se;
	}
}
