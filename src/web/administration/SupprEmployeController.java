package web.administration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import services.IServiceEmploye;
import entities.Employe;

public class SupprEmployeController implements Controller {

	private IServiceEmploye se;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'utilisateur a supprimer
		Employe employe = new Employe();
		employe.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime l'utilisateur
		se.deleteEmploye(employe);
		
		// Redirige vers la liste des utilisateurs
		arg1.sendRedirect("liste_employes.htm");
		
		return null;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

}
