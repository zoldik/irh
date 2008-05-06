package web.formations;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Droit;
import entities.Utilisateur;

import services.IServiceDroit;
import services.IServiceUtilisateur;


public class AddUtilisateurController extends SimpleFormController {
	
	private IServiceUtilisateur su;
	private IServiceDroit sd;
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return super.formBackingObject(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		// Ajoute la liste des droits dans la dataMap
		dataMap.put("droits", sd.listDroits());
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"droit"});
		 
    	Utilisateur user = (Utilisateur)binder.getTarget();
     	
    	Integer droitId = null;
    	try { droitId = Integer.parseInt(request.getParameter("droit")); }
    	catch (Exception e) {}
    	
		if (droitId != null) {
			Droit droit = sd.getDroit(droitId);
			user.setDroit(droit);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Utilisateur user = (Utilisateur)command;
		// Ajout de l'utilisateur
		su.addUtilisateur(user);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceUtilisateur getSu() {
		return su;
	}

	public void setSu(IServiceUtilisateur su) {
		this.su = su;
	}

	public IServiceDroit getSd() {
		return sd;
	}

	public void setSd(IServiceDroit sd) {
		this.sd = sd;
	}
}
