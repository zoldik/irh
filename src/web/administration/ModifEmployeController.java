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
import services.IServiceDiplome;
import services.IServiceEmploiPrecedent;
import services.IServiceEmploye;
import services.IServiceSituationFamiliale;
import entities.Civilite;
import entities.Employe;
import entities.SituationFamiliale;


public class ModifEmployeController extends SimpleFormController {
	
	private IServiceEmploye se;
	private IServiceCivilite sc;
	private IServiceSituationFamiliale ssf;
	private IServiceDiplome sd;
	private IServiceEmploiPrecedent sep;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		
		// Recupère l'employé à modifier
		int employeId = Integer.parseInt(request.getParameter("id"));
		Employe employe = se.getEmploye(employeId);

		return employe;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		
		// Recupère l'employé en modification
		Integer employeId = Integer.parseInt(request.getParameter("id"));
		Employe employe = se.getEmploye(employeId);
		
		// Ajoute l'id de l'employé à la dataMap
    	if (employeId != null) {
    		dataMap.put("employe", employeId);
    	}
		
		// Ajoute la liste des civilites dans la dataMap
		dataMap.put("civilites", sc.listCivilites());
		
		// Ajoute la liste des situations familiales dans la dataMap
		dataMap.put("situationsFamiliale", ssf.listSituationsFamiliale());
		
		// Ajoute les valeurs pour le nombre d'enfants dans la dataMap
		int tabNbsEnfants[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		dataMap.put("nbsEnfants", tabNbsEnfants);
		
		// Liste des diplomes de l'employé
		dataMap.put("diplomes", sd.listDiplomesEmploye(employe));
		
		// Liste des emplois précédents de l'employé
		dataMap.put("emploiPrecedents", sep.listEmploiPrecedentsEmploye(employe));
		
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
		 
		// Gestion de la civilité
    	Employe employe = (Employe)binder.getTarget();
    	Integer civiliteId = null;
    	try { civiliteId = Integer.parseInt(request.getParameter("civilite")); }
    	catch (Exception e) {}
    	
		if (civiliteId != null) {
			Civilite civilite = sc.getCivilite(civiliteId);
			employe.setCivilite(civilite);
		}
		
		// Gestion de la situation familiale
    	Integer situationFamilialeId = null;
    	try { situationFamilialeId = Integer.parseInt(request.getParameter("situationFamiliale")); }
    	catch (Exception e) {}
    	
		if (situationFamilialeId != null) {
			SituationFamiliale situationFamiliale = ssf.getSituationFamiliale(situationFamilialeId);
			employe.setSituationFamiliale(situationFamiliale);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Employe employe = (Employe)command;
		
		// Mise à jour de l'utilisateur
		se.updateEmploye(employe);
		
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

	public IServiceDiplome getSd() {
		return sd;
	}

	public void setSd(IServiceDiplome sd) {
		this.sd = sd;
	}

	public IServiceEmploiPrecedent getSep() {
		return sep;
	}

	public void setSep(IServiceEmploiPrecedent sep) {
		this.sep = sep;
	}
}
