package dao;

import java.util.List;

import entities.Employe;

public interface IDaoEmploye {
	Employe getOne(int id);
	void addOne(Employe comp);
	void updateOne(Employe comp);
	void deleteOne(Employe comp);
	List<Employe> listAll();
}
