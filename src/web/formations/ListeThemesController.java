package web.formations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Theme;

import services.IServiceTheme;

public class ListeThemesController implements Controller {

	private IServiceTheme st;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Theme> themes = st.listThemes();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_themes");
		myModelAndView.addObject("themes", themes);
 
		return myModelAndView;
	}

	public IServiceTheme getSt() {
		return st;
	}

	public void setSt(IServiceTheme st) {
		this.st = st;
	}

}
