package dao;

import java.util.List;

import entities.Civilite;

public interface IDaoCivilite {
	Civilite getOne(int id);
	void addOne(Civilite cat);
	void updateOne(Civilite cat);
	void deleteOne(Civilite cat);
	List<Civilite> listAll();
}
