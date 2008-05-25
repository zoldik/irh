package web.formations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Formation;
import entities.PlanFormation;
import entities.SessionFormation;

import services.IServiceFormation;
import services.IServicePlanFormation;
import services.IServiceSessionFormation;


public class ModifSessionFormationController extends SimpleFormController {
	
	private IServiceSessionFormation ssf;
	private IServicePlanFormation spf;
	private IServiceFormation sf;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int sessionId = Integer.parseInt(request.getParameter("id_session_formation"));
		SessionFormation session = ssf.getSessionFormation(sessionId);
		
		return session;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<Object, Object> dataMap = new HashMap<Object, Object>();
		
		// Ajoute l'id du plan de formation dans la dataMap
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(request.getParameter("id_plan_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		dataMap.put("id_plan_formation", idPlanFormation);
		
		// Ajoute la liste des plans de formation dans la dataMap
		// ici on ajoute que le plan de formation auquel la session de formation
		// appartient
		List<PlanFormation> plan_de_formations = new ArrayList<PlanFormation>();
		for (PlanFormation planFormation : spf.listPlanFormations()) {
			if(planFormation.getId() == idPlanFormation)
				plan_de_formations.add(planFormation);
		}
		dataMap.put("plan_de_formations", plan_de_formations);
		
		// Ajoute la liste des formations dans la dataMap
		dataMap.put("formations", sf.listFormations());
		
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
		binder.setDisallowedFields(new String[] {"planFormation", "formation"});
		 
    	SessionFormation session = (SessionFormation)binder.getTarget();
    	
    	// Gestion du plan de formation
    	Integer planFormationId = null;
    	try { planFormationId = Integer.parseInt(request.getParameter("planFormation")); }
    	catch (Exception e) {}
    	
		if (planFormationId != null) {
			PlanFormation planFormation = spf.getPlanFormation(planFormationId);
			session.setPlanFormation(planFormation);
		}
		
		// Gestion de la formation
    	Integer formationId = null;
    	try { formationId = Integer.parseInt(request.getParameter("formation")); }
    	catch (Exception e) {}
    	
		if (formationId != null) {
			Formation formation = sf.getFormation(formationId);
			session.setFormation(formation);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		SessionFormation session = (SessionFormation)command;
		// Mise a jour
		ssf.updateSessionFormation(session);
		
		return new ModelAndView(new RedirectView(this.getSuccessView() + "?id_plan_formation=" + session.getPlanFormation().getId()));
	}

	public IServiceSessionFormation getSsf() {
		return ssf;
	}

	public void setSsf(IServiceSessionFormation ssf) {
		this.ssf = ssf;
	}

	public IServicePlanFormation getSpf() {
		return spf;
	}

	public void setSpf(IServicePlanFormation spf) {
		this.spf = spf;
	}

	public IServiceFormation getSf() {
		return sf;
	}

	public void setSf(IServiceFormation sf) {
		this.sf = sf;
	}
}
