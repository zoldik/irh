package services;

import java.util.List;

import entities.Diplome;
import entities.Employe;

public interface IServiceDiplome {
	Diplome getDiplome(int id);
	void addDiplome(Diplome diplome);
	void updateDiplome(Diplome diplome);
	void deleteDiplome(Diplome diplome);
	List<Diplome> listDiplomes();
	List<Diplome> listDiplomesEmploye(Employe employe);
}
