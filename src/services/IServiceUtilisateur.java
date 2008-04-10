package services;

import entities.Utilisateur;

public interface IServiceUtilisateur {
	Utilisateur getUtilisateur(int id);
	void addUtilisateur(Utilisateur user);
	void updateUtilisateur(Utilisateur user);
	void deleteUtilisateur(Utilisateur user);
	boolean existeUtilisateur(Utilisateur user);
}
