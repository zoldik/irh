package dao;

import java.util.List;

import entities.Competence;

public interface IDaoCompetence {
	Competence getOne(int id);
	void addOne(Competence comp);
	void updateOne(Competence comp);
	void deleteOne(Competence comp);
	List<Competence> listAll();
}
