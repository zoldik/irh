package web.formations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Employe;
import entities.Inscription;
import entities.InscriptionPK;
import entities.SessionFormation;

import services.IServiceEmploye;
import services.IServiceInscription;
import services.IServiceSessionFormation;



public class ModifInscriptionController extends SimpleFormController {
	
	private IServiceInscription si;
	private IServiceSessionFormation ssf;
	private IServiceEmploye se;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int employeId = Integer.parseInt(request.getParameter("id_employe"));
		int sessionId = Integer.parseInt(request.getParameter("id_session_formation"));
		InscriptionPK pk = new InscriptionPK();
		pk.setIdEmploye(employeId);
		pk.setIdSessionFormation(sessionId);
		
		Inscription inscription = si.getInscription(pk);
		
		return inscription;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		
		// Ajoute l'id de l'employe dans la dataMap
		int idEmploye = -1;
		try { idEmploye = Integer.parseInt(request.getParameter("id_employe")); }
		catch (Exception e) { e.printStackTrace(); }
		dataMap.put("id_employe", idEmploye);
		
		// Ajoute l'id de la session de formation dans la dataMap
		int idSessionFormation = -1;
		try { idSessionFormation = Integer.parseInt(request.getParameter("id_session_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		dataMap.put("id_session_formation", idSessionFormation);
		
		// Ajoute l'id du plan de formation dans la dataMap
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(request.getParameter("id_plan_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		dataMap.put("id_plan_formation", idPlanFormation);
		
		// Ajoute la liste des sessions de formation
		// Ici on ne selectionne que la session concerne
		List<SessionFormation> sessionFormations = new ArrayList<SessionFormation>();
		for (SessionFormation sessionFormation : ssf.listSessionFormations()) {
			if(sessionFormation.getId() == idSessionFormation)
				sessionFormations.add(sessionFormation);
		}
		dataMap.put("session_formations", sessionFormations);
		
		// Ajoute la liste des employe dans la dataMap
		// Ici on ne selectionne que l'employe concerne
		List<Employe> employes = new ArrayList<Employe>();
		for (Employe employe : se.listEmployes()) {
			if(employe.getId() == idEmploye)
				employes.add(employe);
		}
		dataMap.put("employes", employes);
		
		// Ajoute la liste des etats dans la dataMap
		String tabEtats[] = {"En attente", "Valide", "Annule"};
		dataMap.put("etats", tabEtats);
		
		return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		// Gestion des listes deroulantes
		binder.setDisallowedFields(new String[] {"employe", "sessionFormation"});
		 
    	Inscription inscription = (Inscription)binder.getTarget();
    	
    	// Gestion de la session de formation
    	Integer sessionFormationId = null;
    	try { sessionFormationId = Integer.parseInt(request.getParameter("sessionFormation")); }
    	catch (Exception e) {}
    	
		if (sessionFormationId != null) {
			SessionFormation sessionFormation = ssf.getSessionFormation(sessionFormationId);
			inscription.setSessionFormation(sessionFormation);
		}
    	
    	// Gestion de l'employe
    	Integer employeId = null;
    	try { employeId = Integer.parseInt(request.getParameter("employe")); }
    	catch (Exception e) {}
    	
		if (employeId != null) {
			Employe employe = se.getEmploye(employeId);
			inscription.setEmploye(employe);
		}
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		Inscription inscription = (Inscription)command;
		
		// Recuperation de l'id du plan de formation
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(request.getParameter("id_plan_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		
		// Mise a jour
		si.updateInscription(inscription);
		
		return new ModelAndView(new RedirectView(this.getSuccessView() + "?id_session_formation=" + inscription.getPk().getIdSessionFormation() + "&id_plan_formation=" + idPlanFormation));
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}
}
