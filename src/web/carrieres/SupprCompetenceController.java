package web.carrieres;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Competence;

import services.IServiceCompetence;

public class SupprCompetenceController implements Controller {

	private IServiceCompetence sc;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'element à supprimer
		Competence comp = new Competence();
		comp.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime
		sc.deleteCompetence(comp);
		// Redirige vers la liste
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_competences.htm");
		
		return null;
	}

	public IServiceCompetence getSc() {
		return sc;
	}

	public void setSc(IServiceCompetence sc) {
		this.sc = sc;
	}

}
