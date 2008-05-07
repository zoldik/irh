package web.formations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Metier;

import services.IServiceMetier;

public class ListeMetiersController implements Controller {

	private IServiceMetier sm;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Metier> metiers = sm.listMetiers();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_metiers");
		myModelAndView.addObject("metiers", metiers);
 
		return myModelAndView;
	}

	public IServiceMetier getSm() {
		return sm;
	}

	public void setSm(IServiceMetier sm) {
		this.sm = sm;
	}

}
