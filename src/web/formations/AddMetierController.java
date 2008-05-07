package web.formations;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Categorie;
import entities.Metier;

import services.IServiceCategorie;
import services.IServiceMetier;


public class AddMetierController extends SimpleFormController {
	
	private IServiceCategorie sc;
	private IServiceMetier sm;
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
		// Ajoute la liste des categories dans la dataMap
		dataMap.put("categories", sc.listCategories());
		
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"categorie"});
		 
		Metier metier = (Metier)binder.getTarget();
     	
    	Integer id = null;
    	try { id = Integer.parseInt(request.getParameter("categorie")); }
    	catch (Exception e) {}
    	
		if (id != null) {
			Categorie cat = sc.getCategorie(id);
			metier.setCategorie(cat);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Metier metier = (Metier)command;
		// Ajout de la categorie
		sm.addMetier(metier);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceCategorie getSc() {
		return sc;
	}

	public void setSc(IServiceCategorie sc) {
		this.sc = sc;
	}

	public IServiceMetier getSm() {
		return sm;
	}

	public void setSm(IServiceMetier sm) {
		this.sm = sm;
	}
}
