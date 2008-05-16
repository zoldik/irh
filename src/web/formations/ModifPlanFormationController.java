package web.formations;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import entities.PlanFormation;

import services.IServicePlanFormation;


public class ModifPlanFormationController extends SimpleFormController {
	
	private IServicePlanFormation spf;
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int Id = Integer.parseInt(request.getParameter("id"));
		PlanFormation plan = spf.getPlanFormation(Id);
		
		return plan;		
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		return super.referenceData(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		PlanFormation plan = (PlanFormation)command;
		// Mise a jour
		spf.updatePlanFormation(plan);
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServicePlanFormation getSpf() {
		return spf;
	}

	public void setSpf(IServicePlanFormation spf) {
		this.spf = spf;
	}
}
