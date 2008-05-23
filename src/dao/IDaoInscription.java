package dao;

import java.util.List;

import entities.Inscription;
import entities.InscriptionPK;

public interface IDaoInscription {
	Inscription getOne(InscriptionPK pk);
	void addOne(Inscription inscription);
	void updateOne(Inscription inscription);
	void deleteOne(Inscription inscription);
	List<Inscription> listAll();
}
