package services;

import java.util.List;

import entities.PlanFormation;

public interface IServicePlanFormation {
	PlanFormation getPlanFormation(int id);
	void addPlanFormation(PlanFormation plan);
	void updatePlanFormation(PlanFormation plan);
	void deletePlanFormation(PlanFormation plan);
	List<PlanFormation> listPlanFormations();
}
