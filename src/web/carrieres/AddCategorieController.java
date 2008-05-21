package web.carrieres;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Categorie;
import entities.Theme;

import services.IServiceCategorie;
import services.IServiceTheme;


public class AddCategorieController extends SimpleFormController {
	
	private IServiceCategorie sc;
	private IServiceTheme st;
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
		// Ajoute la liste des themes dans la dataMap
		dataMap.put("themes", st.listThemes());
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"theme"});
		 
    	Categorie cat = (Categorie)binder.getTarget();
     	
    	Integer id = null;
    	try { id = Integer.parseInt(request.getParameter("theme")); }
    	catch (Exception e) {}
    	
		if (id != null) {
			Theme theme = st.getTheme(id);
			cat.setTheme(theme);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Categorie cat = (Categorie)command;
		// Ajout de la categorie
		sc.addCategorie(cat);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceCategorie getSc() {
		return sc;
	}

	public void setSc(IServiceCategorie sc) {
		this.sc = sc;
	}

	public IServiceTheme getSt() {
		return st;
	}

	public void setSt(IServiceTheme st) {
		this.st = st;
	}
}
