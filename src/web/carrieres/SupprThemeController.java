package web.carrieres;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Theme;

import services.IServiceTheme;

public class SupprThemeController implements Controller {

	private IServiceTheme st;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere le theme � supprimer
		Theme theme = new Theme();
		theme.setId(Integer.parseInt(arg0.getParameter("id")));
		// Supprime
		st.deleteTheme(theme);
		// Redirige vers la liste des utilisateurs
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		arg1.sendRedirect("liste_themes.htm");
		
		return null;
	}

	public IServiceTheme getSt() {
		return st;
	}

	public void setSt(IServiceTheme st) {
		this.st = st;
	}

}
