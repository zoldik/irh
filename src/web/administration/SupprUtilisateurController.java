package web.administration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Utilisateur;

import services.IServiceUtilisateur;

public class SupprUtilisateurController implements Controller {

	private IServiceUtilisateur su;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'utilisateur à supprimer
		Utilisateur user = new Utilisateur();
		user.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime l'utilisateur
		su.deleteUtilisateur(user);
		// Redirige vers la liste des utilisateurs
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_utilisateurs.htm");
		
		return null;
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}

}
