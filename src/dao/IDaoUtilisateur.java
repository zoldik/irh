package dao;

import entities.Utilisateur;

public interface IDaoUtilisateur {
	Utilisateur getOne(int id);
	void addOne(Utilisateur user);
	void updateOne(Utilisateur user);
	void deleteOne(Utilisateur user);
}
