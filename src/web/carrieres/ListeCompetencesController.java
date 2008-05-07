package web.carrieres;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Competence;

import services.IServiceCompetence;

public class ListeCompetencesController implements Controller {

	private IServiceCompetence sc;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Competence> competences = sc.listCompetences();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_competences");
		myModelAndView.addObject("competences", competences);
 
		return myModelAndView;
	}

	public IServiceCompetence getSc() {
		return sc;
	}

	public void setSc(IServiceCompetence sc) {
		this.sc = sc;
	}
}
