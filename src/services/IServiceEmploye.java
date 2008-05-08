package services;

import java.util.List;

import entities.Employe;

public interface IServiceEmploye {
	Employe getEmploye(int id);
	void addEmploye(Employe employe);
	void updateEmploye(Employe employe);
	void deleteEmploye(Employe employe);
	List<Employe> listEmployes();
}
