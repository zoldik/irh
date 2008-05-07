package dao;

import java.util.List;

import entities.Contrat;

public interface IDaoContrat {
	Contrat getOne(int id);
	void addOne(Contrat contrat);
	void updateOne(Contrat contrat);
	void deleteOne(Contrat contrat);
	List<Contrat> listAll();
}
