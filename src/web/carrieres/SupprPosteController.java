package web.carrieres;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Poste;

import services.IServicePoste;

public class SupprPosteController implements Controller {

	private IServicePoste sp;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'element a supprimer
		Poste poste = new Poste();
		poste.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime l'element
		sp.deletePoste(poste);
		// Redirige vers la liste
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_postes.htm");
		
		return null;
	}

	public IServicePoste getSp() {
		return sp;
	}

	public void setSp(IServicePoste sp) {
		this.sp = sp;
	}
}
