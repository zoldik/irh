package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoUtilisateur;

import entities.Utilisateur;

@Transactional
public class ServiceUtilisateur implements IServiceUtilisateur {
	// Couche [dao]
	private IDaoUtilisateur daoUtilisateur;
	
	public IDaoUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}
	
	public void setDaoUtilisateur(IDaoUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}
	
	@Override
	public void addUtilisateur(Utilisateur user) {
		this.daoUtilisateur.addOne(user);
	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		this.daoUtilisateur.deleteOne(user);
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		return this.daoUtilisateur.getOne(id);
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		this.daoUtilisateur.updateOne(user);
	}
	
	@Override
	public boolean existeUtilisateur(Utilisateur user) {
		return this.daoUtilisateur.existe(user);
	}
	
	@Override
	public List<Utilisateur> listUtilisateurs() {
		return this.daoUtilisateur.listAll();
	}
}
