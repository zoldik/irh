package services;

import java.util.List;

import entities.EmploiPrecedent;
import entities.Employe;

public interface IServiceEmploiPrecedent {
	EmploiPrecedent getEmploiPrecedent(int id);
	void addEmploiPrecedent(EmploiPrecedent emploiPrecedent);
	void updateEmploiPrecedent(EmploiPrecedent emploiPrecedent);
	void deleteEmploiPrecedent(EmploiPrecedent emploiPrecedent);
	List<EmploiPrecedent> listEmploiPrecedents();
	List<EmploiPrecedent> listEmploiPrecedentsEmploye(Employe employe);
}
