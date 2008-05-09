package services;

import java.util.List;

import entities.Formation;

public interface IServiceFormation {
	Formation getFormation(int id);
	void addFormation(Formation formation);
	void updateFormation(Formation formation);
	void deleteFormation(Formation formation);
	List<Formation> listFormations();
}
