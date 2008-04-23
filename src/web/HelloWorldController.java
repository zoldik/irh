package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import services.IServiceUtilisateur;
import entities.Utilisateur;

public class HelloWorldController implements Controller {

	private IServiceUtilisateur su;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{				
		Utilisateur user = su.getUtilisateur(1);
		
		System.out.println("## " + user.getNom());
		
		//user.setNom("test3");
		//su.updateUtilisateur(user);
		
		System.out.println("## " + user.getNom());
		
		for (Utilisateur u : su.listUtilisateurs()) {
			System.out.println(u.getLogin());
		}
		
		ModelAndView myModelAndView = new ModelAndView("helloworld");
		myModelAndView.addObject("user", user);
 
		return myModelAndView;
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}

}
