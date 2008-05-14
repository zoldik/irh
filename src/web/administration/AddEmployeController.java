package web.administration;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import services.IServiceCivilite;
import services.IServiceEmploye;
import services.IServiceSituationFamiliale;
import entities.Civilite;
import entities.Employe;
import entities.SituationFamiliale;


public class AddEmployeController extends SimpleFormController {
	
	private IServiceEmploye se;
	private IServiceCivilite sc;
	private IServiceSituationFamiliale ssf;
	
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
	protected Map<Object, Object> referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		// Ajoute la liste des civilites dans la dataMap
		dataMap.put("civilites", sc.listCivilites());
		
		// Ajoute la liste des situations familiales dans la dataMap
		dataMap.put("situationsFamiliale", ssf.listSituationsFamiliale());
		
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		// format (dd/MM/yyyy) attendu pour les dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// format strict
		dateFormat.setLenient(false);
		// on enregistre un éditeur de propriétés String (dd/MM/yyyy) -> Date
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
		
		// Gestion des listes deroulantes
		binder.setDisallowedFields(new String[] {"civilite", "situationFamiliale"});
		 
    	Employe employe = (Employe)binder.getTarget();
     	
    	// Gestion de la civilité
    	Integer civiliteId = null;
    	try { civiliteId = Integer.parseInt(request.getParameter("civilite")); }
    	catch (Exception e) {}
    	
		if (civiliteId != null) {
			Civilite civilite = sc.getCivilite(civiliteId);
			employe.setCivilite(civilite);
		}
		
		// Gestion de la situationFamiliale
    	Integer situationFamilialeId = null;
    	try { situationFamilialeId = Integer.parseInt(request.getParameter("situationFamiliale")); }
    	catch (Exception e) {}
    	
		if (situationFamilialeId != null) {
			SituationFamiliale situationFamiliale = ssf.getSituationFamiliale(civiliteId);
			employe.setSituationFamiliale(situationFamiliale);
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
	
	public IServiceSituationFamiliale getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSituationFamiliale ssf) {
		this.ssf = ssf;
	}
}
