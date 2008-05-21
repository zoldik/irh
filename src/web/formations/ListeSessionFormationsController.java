package web.formations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.SessionFormation;

import services.IServiceSessionFormation;

public class ListeSessionFormationsController implements Controller {

	private IServiceSessionFormation ssf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere la liste
		List<SessionFormation> session_formations = ssf.listSessionFormations();
		// Ajoute la liste au Model
		ModelAndView myModelAndView = new ModelAndView("liste_session_formations");
		myModelAndView.addObject("session_formations", session_formations);
 
		return myModelAndView;
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}
}
