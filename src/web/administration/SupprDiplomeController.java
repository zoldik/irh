package web.administration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import services.IServiceDiplome;
import entities.Diplome;

public class SupprDiplomeController implements Controller {

	private IServiceDiplome sd;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'utilisateur � supprimer
		Diplome diplome = sd.getDiplome(Integer.parseInt(arg0.getParameter("id")));
		
		// Supprime l'utilisateur
		sd.deleteDiplome(diplome);
		
		// Redirige vers l'employe
		arg1.sendRedirect("modif_employe.htm?id=" + diplome.getEmploye().getId());
		
		return null;
	}

	public IServiceDiplome getSd() {
		return sd;
	}

	public void setSd(IServiceDiplome sd) {
		this.sd = sd;
	}

}
