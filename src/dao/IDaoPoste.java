package dao;

import java.util.List;

import entities.Poste;

public interface IDaoPoste {
	Poste getOne(int id);
	void addOne(Poste poste);
	void updateOne(Poste poste);
	void deleteOne(Poste poste);
	List<Poste> listAll();
}
