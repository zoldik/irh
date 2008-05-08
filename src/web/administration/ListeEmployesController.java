package web.administration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import services.IServiceEmploye;
import entities.Employe;

public class ListeEmployesController implements Controller {

	private IServiceEmploye se;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste des utilisateurs
		List<Employe> employes = se.listEmployes();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_employes");
		myModelAndView.addObject("employes", employes);
 
		return myModelAndView;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

}
