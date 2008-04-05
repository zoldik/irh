package services;

import dao.IDaoUtilisateur;
import entities.Utilisateur;

public class ServiceUtilisateur implements IServiceUtilisateur {

	// Couche [dao]
	private IDaoUtilisateur daoUser;
	
	public IDaoUtilisateur getDaoUser() {
		return daoUser;
	}
	
	public void setDaoUser(IDaoUtilisateur daoUser) {
		this.daoUser = daoUser;
	}
	
	@Override
	public void addUtilisateur(Utilisateur user) {
		this.daoUser.addOne(user);
	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		this.daoUser.deleteOne(user);
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		return this.daoUser.getOne(id);
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		this.daoUser.updateOne(user);
	}

}
