package web.carrieres;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Categorie;

import services.IServiceCategorie;

public class ListeCategoriesController implements Controller {

	private IServiceCategorie sc;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Categorie> categories = sc.listCategories();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_categories");
		myModelAndView.addObject("categories", categories);
 
		return myModelAndView;
	}

	public IServiceCategorie getSc() {
		return sc;
	}

	public void setSc(IServiceCategorie sc) {
		this.sc = sc;
	}
}
