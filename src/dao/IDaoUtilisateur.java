package dao;

import java.util.List;

import entities.Droit;
import entities.Utilisateur;

public interface IDaoUtilisateur {
	Utilisateur getOne(int id);
	void addOne(Utilisateur user);
	void updateOne(Utilisateur user);
	void deleteOne(Utilisateur user);
	List<Utilisateur> listAll();
	boolean existe(Utilisateur user);
}
