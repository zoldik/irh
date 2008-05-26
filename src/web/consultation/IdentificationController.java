package web.consultation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import services.IServiceUtilisateur;
import entities.Utilisateur;


public class IdentificationController extends SimpleFormController {
	
	private IServiceUtilisateur su;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		
		// Création d'une nouvelle session
		request.getSession(true);
		
		return super.formBackingObject(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		return super.referenceData(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		super.initBinder(request, binder);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		Utilisateur user = (Utilisateur)command;
		
		for (Utilisateur u : su.listUtilisateurs()) {
			if (u.getLogin().equals(user.getLogin())) {
				user = su.getUtilisateur(u.getId());
			}
		}
		
		// Recuperation de la session
		HttpSession httpSession = request.getSession();
		
		// Ajout de l'utilisateur dans la session
		httpSession.setAttribute("nom", user.getNom());
		httpSession.setAttribute("droit", user.getDroit().getLibelle());
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}
}
