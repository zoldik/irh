package web.administration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import services.IServiceEmploiPrecedent;
import entities.EmploiPrecedent;

public class SupprEmploiPrecedentController implements Controller {

	private IServiceEmploiPrecedent sep;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere emploi à supprimer
		EmploiPrecedent emploiPrecedent = sep.getEmploiPrecedent(Integer.parseInt(arg0.getParameter("id")));
		
		// Supprime l'utilisateur
		sep.deleteEmploiPrecedent(emploiPrecedent);
		
		// Redirige vers l'employe
		arg1.sendRedirect("modif_employe.htm?id=" + emploiPrecedent.getEmploye().getId());
		
		return null;
	}

	public IServiceEmploiPrecedent getSep() {
		return sep;
	}

	public void setSep(IServiceEmploiPrecedent sep) {
		this.sep = sep;
	}
	
}
