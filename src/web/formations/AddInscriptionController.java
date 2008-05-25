package web.formations;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


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

public class AddInscriptionController extends SimpleFormController {
	
	private IServiceInscription si;
	private IServiceEmploye se;
	private IServiceSessionFormation ssf;

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
		dataMap.put("employes", se.listEmployes());
		
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
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		
		Inscription inscription = (Inscription)command;
		
		// Ajout
		InscriptionPK pk = new InscriptionPK();
		pk.setIdEmploye(inscription.getEmploye().getId());
		pk.setIdSessionFormation(inscription.getSessionFormation().getId());
		inscription.setPk(pk);
		
		si.addInscription(inscription);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView() + "?id_session_formation=" + inscription.getPk().getIdSessionFormation()));
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}

	public IServiceEmploye getSe() {
		return se;
	}

	public void setSe(IServiceEmploye se) {
		this.se = se;
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}
}
