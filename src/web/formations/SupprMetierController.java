package web.formations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Metier;

import services.IServiceMetier;

public class SupprMetierController implements Controller {

	private IServiceMetier sm;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'element à supprimer
		Metier metier = new Metier();
		metier.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime l'element
		sm.deleteMetier(metier);
		// Redirige vers la liste
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_metiers.htm");
		
		return null;
	}

	public IServiceMetier getSm() {
		return sm;
	}

	public void setSm(IServiceMetier sm) {
		this.sm = sm;
	}

}
