package web.carrieres;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.Employe;
import entities.Evaluation;


import services.IServiceCompetence;
import services.IServiceEmploye;
import services.IServiceEvaluation;


public class AddEvaluationController extends SimpleFormController {
	
	private IServiceEvaluation se;
	private IServiceEmploye see;
	private IServiceCompetence sc;

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
		
		// Ajoute la liste des employes dans la dataMap
		dataMap.put("employes", see.listEmployes());
		
		// Ajoute la liste des competences dans la dataMap
		dataMap.put("competences", sc.listCompetences());
		
		// Ajoute la liste des niveaux de competences dans la dataMap
		int tabNiveauCompetences[] = {1, 2, 3, 4, 5};
		dataMap.put("niveau_competences", tabNiveauCompetences);    	
		
		return dataMap;	   	
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.setDisallowedFields(new String[] {"employe", "competence"});
    	Evaluation evaluation = (Evaluation)binder.getTarget();
     	
    	// Gestion de employe
    	Integer idEmploye = null;
    	try { idEmploye = Integer.parseInt(request.getParameter("employe")); }
    	catch (Exception e) {}
    	
		if (idEmploye != null) {
			Employe employe = see.getEmploye(idEmploye);
			evaluation.setEmploye(employe);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Evaluation evaluation = (Evaluation)command;
		// Ajout
		se.addEvaluation(evaluation);	
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceEvaluation getSe() {
		return se;
	}

	public void setSe(IServiceEvaluation se) {
		this.se = se;
	}

	public IServiceEmploye getSee() {
		return see;
	}

	public void setSee(IServiceEmploye see) {
		this.see = see;
	}

	public IServiceCompetence getSc() {
		return sc;
	}

	public void setSc(IServiceCompetence sc) {
		this.sc = sc;
	}
}
