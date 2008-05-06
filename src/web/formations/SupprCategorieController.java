package web.formations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Categorie;

import services.IServiceCategorie;

public class SupprCategorieController implements Controller {

	private IServiceCategorie sc;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere l'element à supprimer
		Categorie cat = new Categorie();
		cat.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime l'element
		sc.deleteCategorie(cat);
		// Redirige vers la liste des utilisateurs
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_categories.htm");
		
		return null;
	}

	public IServiceCategorie getSc() {
		return sc;
	}

	public void setSc(IServiceCategorie sc) {
		this.sc = sc;
	}

}
