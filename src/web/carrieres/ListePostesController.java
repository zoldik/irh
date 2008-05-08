package web.carrieres;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Poste;

import services.IServicePoste;

public class ListePostesController implements Controller {

	private IServicePoste sp;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<Poste> postes = sp.listPostes();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_postes");
		myModelAndView.addObject("postes", postes);
 
		return myModelAndView;
	}

	public IServicePoste getSp() {
		return sp;
	}

	public void setSp(IServicePoste sp) {
		this.sp = sp;
	}
}
