package web.administration;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import services.IServiceDiplome;
import services.IServiceEmploye;
import services.IServiceNiveauEtude;
import entities.Diplome;
import entities.Employe;
import entities.NiveauEtude;


public class ModifDiplomeController extends SimpleFormController {
	
	private IServiceDiplome sd;
	private IServiceNiveauEtude sne;
	private IServiceEmploye se;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int diplomeId = Integer.parseInt(request.getParameter("id"));
		Diplome diplome = sd.getDiplome(diplomeId);
		
		return diplome;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		
		// Recupère l'employé passé en paramètre GET
		Integer employeId = Integer.parseInt(request.getParameter("employe"));
    	// Ajoute l'id de l'employé à la dataMap
    	if (employeId != null) {
    		dataMap.put("employeId", employeId);
    	}
		
		// Ajoute la liste des niveaux d'etude dans la dataMap
		dataMap.put("niveauxEtude", sne.listNiveauxEtude());
		
    	return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		// Champs a ne pas gerer par le binder
		binder.setDisallowedFields(new String[] {"niveauEtude", "employe"});
		 
		Diplome diplome = (Diplome)binder.getTarget();
     	
		// Gestion de l'employé
		Integer employeId = null;
    	try { employeId = Integer.parseInt(request.getParameter("employeid")); }
    	catch (Exception e) {}
    	
    	if (employeId != null) {
			Employe employe = se.getEmploye(employeId);
			diplome.setEmploye(employe);
		}
		
    	// Gestion du niveau d'etude
    	Integer niveauEtudeId = null;
    	try { niveauEtudeId = Integer.parseInt(request.getParameter("niveauEtude")); }
    	catch (Exception e) {}
    	
		if (niveauEtudeId != null) {
			NiveauEtude niveauEtude = sne.getNiveauEtude(niveauEtudeId);
			diplome.setNiveauEtude(niveauEtude);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Diplome diplome = (Diplome)command;
		
		// Mise a jour du diplome
		sd.updateDiplome(diplome);
		
		return new ModelAndView(new RedirectView(this.getSuccessView() + "?id=" + diplome.getEmploye().getId()));
	}

	public IServiceDiplome getSd() {
		return sd;
	}

	public void setSd(IServiceDiplome sd) {
		this.sd = sd;
	}

	public IServiceNiveauEtude getSne() {
		return sne;
	}

	public void setSne(IServiceNiveauEtude sne) {
		this.sne = sne;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

}
