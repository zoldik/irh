package dao;

import java.util.List;

import entities.Organisme;

public interface IDaoOrganisme {
	Organisme getOne(int id);
	void addOne(Organisme orga);
	void updateOne(Organisme orga);
	void deleteOne(Organisme orga);
	List<Organisme> listAll();
}
