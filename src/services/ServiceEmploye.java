package services;

import java.util.List;

import dao.IDaoEmploye;
import entities.Employe;

public class ServiceEmploye implements IServiceEmploye {
	// Couche [dao]
	private IDaoEmploye daoEmploye;
	
	public IDaoEmploye getDaoEmploye() {
		return daoEmploye;
	}

	public void setDaoEmploye(IDaoEmploye daoEmploye) {
		this.daoEmploye = daoEmploye;
	}

	@Override
	public void addEmploye(Employe employe) {
		this.daoEmploye.addOne(employe);		
	}

	@Override
	public void deleteEmploye(Employe employe) {
		this.daoEmploye.deleteOne(employe);		
	}

	@Override
	public Employe getEmploye(int id) {
		return this.daoEmploye.getOne(id);
	}

	@Override
	public List<Employe> listEmployes() {
		return this.daoEmploye.listAll();
	}

	@Override
	public void updateEmploye(Employe employe) {
		this.daoEmploye.updateOne(employe);
	}
}
