package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoPlanFormation;

import entities.PlanFormation;

@Transactional
public class ServicePlanFormation implements IServicePlanFormation {
	// Couche [dao]
	private IDaoPlanFormation daoPlanFormation;

	public IDaoPlanFormation getDaoPlanFormation() {
		return daoPlanFormation;
	}

	public void setDaoPlanFormation(IDaoPlanFormation daoPlanFormation) {
		this.daoPlanFormation = daoPlanFormation;
	}

	@Override
	public void addPlanFormation(PlanFormation plan) {
		this.daoPlanFormation.addOne(plan);		
	}

	@Override
	public void deletePlanFormation(PlanFormation plan) {
		this.daoPlanFormation.deleteOne(plan);		
	}

	@Override
	public PlanFormation getPlanFormation(int id) {
		return this.daoPlanFormation.getOne(id);
	}

	@Override
	public List<PlanFormation> listPlanFormations() {
		return this.daoPlanFormation.listAll();
	}

	@Override
	public void updatePlanFormation(PlanFormation plan) {
		this.daoPlanFormation.updateOne(plan);
	}	
}
