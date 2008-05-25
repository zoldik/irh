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

import services.IServiceContrat;
import services.IServiceEmploiPrecedent;
import services.IServiceEmploye;
import entities.Contrat;
import entities.EmploiPrecedent;
import entities.Employe;


public class AddEmploiPrecedentController extends SimpleFormController {
	
	private IServiceEmploiPrecedent sep;
	private IServiceContrat sc;
	private IServiceEmploye se;

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
		
		// Recupère l'employé passé en paramètre GET
		Integer employeId = Integer.parseInt(request.getParameter("employe"));
    	// Ajoute l'id de l'employé à la dataMap
    	if (employeId != null) {
    		dataMap.put("employeId", employeId);
    	}
		
		// Ajoute la liste des niveaux d'etude dans la dataMap
		dataMap.put("contrats", sc.listContrats());

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
		
		// Champs a ne pas gerer par le binder
		binder.setDisallowedFields(new String[] {"contrat", "employe"});
		 
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)binder.getTarget();
     	
		// Gestion de l'employé
		Integer employeId = null;
    	try { employeId = Integer.parseInt(request.getParameter("employeid")); }
    	catch (Exception e) {}
    	
    	if (employeId != null) {
			Employe employe = se.getEmploye(employeId);
			emploiPrecedent.setEmploye(employe);
		}
		
    	// Gestion du niveau d'etude
    	Integer contratId = null;
    	try { contratId = Integer.parseInt(request.getParameter("contrat")); }
    	catch (Exception e) {}
    	
		if (contratId != null) {
			Contrat contrat = sc.getContrat(contratId);
			emploiPrecedent.setContrat(contrat);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		System.out.println("### onSubmit");
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)command;
		
		// Ajout du diplome
		sep.addEmploiPrecedent(emploiPrecedent);
		
		return new ModelAndView(new RedirectView(this.getSuccessView() + "?id=" + emploiPrecedent.getEmploye().getId()));
	}

	public IServiceEmploiPrecedent getSep() {
		return sep;
	}

	public void setSep(IServiceEmploiPrecedent sep) {
		this.sep = sep;
	}

	public IServiceContrat getSc() {
		return sc;
	}

	public void setSc(IServiceContrat sc) {
		this.sc = sc;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

}
