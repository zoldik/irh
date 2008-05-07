package services;

import java.util.List;

import entities.Competence;

public interface IServiceCompetence {
	Competence getCompetence(int id);
	void addCompetence(Competence comp);
	void updateCompetence(Competence comp);
	void deleteCompetence(Competence comp);
	List<Competence> listCompetences();
}
