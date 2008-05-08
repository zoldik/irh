package web.administration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import services.IServiceCivilite;
import services.IServiceEmploye;
import entities.Civilite;
import entities.Employe;


public class AddEmployeController extends SimpleFormController {
	
	private IServiceEmploye se;
	private IServiceCivilite sc;
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		return super.formBackingObject(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		// Ajoute la liste des civilites dans la dataMap
		dataMap.put("civilites", sc.listCivilites());
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"civilite"});
		 
    	Employe employe = (Employe)binder.getTarget();
     	
    	Integer civiliteId = null;
    	try { civiliteId = Integer.parseInt(request.getParameter("civilite")); }
    	catch (Exception e) {}
    	
		if (civiliteId != null) {
			Civilite civilite = sc.getCivilite(civiliteId);
			employe.setCivilite(civilite);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Employe employe = (Employe)command;
		// Ajout de l'utilisateur
		se.addEmploye(employe);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

	public IServiceCivilite getSc() {
		return sc;
	}

	public void setSc(IServiceCivilite sc) {
		this.sc = sc;
	}
}
