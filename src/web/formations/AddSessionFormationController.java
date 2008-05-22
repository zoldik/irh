package web.formations;

import java.text.SimpleDateFormat;
import java.util.HashMap;
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



public class AddSessionFormationController extends SimpleFormController {
	
	private IServiceSessionFormation ssf;
	private IServicePlanFormation spf;
	private IServiceFormation sf;

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
		
		// Ajoute la liste des plans de formation dans la dataMap
		dataMap.put("plan_de_formations", spf.listPlanFormations());
		
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
		// Ajout
		ssf.addSessionFormation(session);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
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
