package dao;

import java.util.List;

import entities.PlanFormation;

public interface IDaoPlanFormation {
	PlanFormation getOne(int id);
	void addOne(PlanFormation plan);
	void updateOne(PlanFormation plan);
	void deleteOne(PlanFormation plan);
	List<PlanFormation> listAll();
}
