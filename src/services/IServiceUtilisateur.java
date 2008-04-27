package services;

import java.util.List;

import entities.Droit;
import entities.Utilisateur;

public interface IServiceUtilisateur {
	Utilisateur getUtilisateur(int id);
	void addUtilisateur(Utilisateur user);
	void updateUtilisateur(Utilisateur user);
	void deleteUtilisateur(Utilisateur user);
	List<Utilisateur> listUtilisateurs();
	boolean existeUtilisateur(Utilisateur user);
}
