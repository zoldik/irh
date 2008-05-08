package web.carrieres;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Poste;
import entities.Metier;

import services.IServicePoste;
import services.IServiceMetier;


public class ModifPosteController extends SimpleFormController {
	
	private IServicePoste sp;
	private IServiceMetier sm;
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Poste poste = sp.getPoste(id);
		
		return poste;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		// Ajoute la liste des metiers dans la dataMap
		dataMap.put("metiers", sm.listMetiers());
		
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"metier"});
		 
		Poste poste = (Poste)binder.getTarget();
    	Integer id = null;
    	try { id = Integer.parseInt(request.getParameter("metier")); }
    	catch (Exception e) {}
    	
		if (id != null) {
			Metier metier = sm.getMetier(id);
			poste.setMetier(metier);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Poste poste = (Poste)command;
		// Mise a jour
		sp.updatePoste(poste);
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceMetier getSm() {
		return sm;
	}

	public void setSm(IServiceMetier sm) {
		this.sm = sm;
	}

	public IServicePoste getSp() {
		return sp;
	}

	public void setSp(IServicePoste sp) {
		this.sp = sp;
	}

}
