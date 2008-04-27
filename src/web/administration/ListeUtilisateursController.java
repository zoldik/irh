package web.administration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Utilisateur;

import services.IServiceUtilisateur;

public class ListeUtilisateursController implements Controller {

	private IServiceUtilisateur su;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste des utilisateurs
		List<Utilisateur> users = su.listUtilisateurs();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_utilisateurs");
		myModelAndView.addObject("users", users);
 
		return myModelAndView;
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}

}
