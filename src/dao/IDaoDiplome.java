package dao;

import java.util.List;

import entities.Diplome;
import entities.Employe;

public interface IDaoDiplome {
	Diplome getOne(int id);
	void addOne(Diplome diplome);
	void updateOne(Diplome diplome);
	void deleteOne(Diplome diplome);
	List<Diplome> listAll();
	List<Diplome> listAllEmploye(Employe employe);
}
