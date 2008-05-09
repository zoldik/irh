package dao;

import java.util.List;

import entities.Formation;

public interface IDaoFormation {
	Formation getOne(int id);
	void addOne(Formation formation);
	void updateOne(Formation formation);
	void deleteOne(Formation formation);
	List<Formation> listAll();
}
