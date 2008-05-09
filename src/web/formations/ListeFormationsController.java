package web.formations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Formation;

import services.IServiceFormation;

public class ListeFormationsController implements Controller {

	private IServiceFormation sf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Formation> formations = sf.listFormations();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_formations");
		myModelAndView.addObject("formations", formations);
 
		return myModelAndView;
	}

	public IServiceFormation getSf() {
		return sf;
	}

	public void setSf(IServiceFormation sf) {
		this.sf = sf;
	}
}
