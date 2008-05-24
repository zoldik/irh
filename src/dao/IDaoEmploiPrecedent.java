package dao;

import java.util.List;

import entities.EmploiPrecedent;
import entities.Employe;

public interface IDaoEmploiPrecedent {
	EmploiPrecedent getOne(int id);
	void addOne(EmploiPrecedent emploiPrecedent);
	void updateOne(EmploiPrecedent emploiPrecedent);
	void deleteOne(EmploiPrecedent emploiPrecedent);
	List<EmploiPrecedent> listAll();
	List<EmploiPrecedent> listAllEmploye(Employe employe);
}
