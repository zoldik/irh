package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoEmploiPrecedent;
import entities.EmploiPrecedent;
import entities.Employe;

@Transactional
public class ServiceEmploiPrecedent implements IServiceEmploiPrecedent {
	// Couche [dao]
	private IDaoEmploiPrecedent daoEmploiPrecedent;
	
	public IDaoEmploiPrecedent getDaoEmploiPrecedent() {
		return daoEmploiPrecedent;
	}

	public void setDaoEmploiPrecedent(IDaoEmploiPrecedent daoEmploiPrecedent) {
		this.daoEmploiPrecedent = daoEmploiPrecedent;
	}

	@Override
	public void addEmploiPrecedent(EmploiPrecedent emploiPrecedent) {
		this.daoEmploiPrecedent.addOne(emploiPrecedent);
	}

	@Override
	public void deleteEmploiPrecedent(EmploiPrecedent emploiPrecedent) {
		this.daoEmploiPrecedent.deleteOne(emploiPrecedent);
	}

	@Override
	public EmploiPrecedent getEmploiPrecedent(int id) {
		return this.daoEmploiPrecedent.getOne(id);
	}
	
	@Override
	public void updateEmploiPrecedent(EmploiPrecedent emploiPrecedent) {
		this.daoEmploiPrecedent.updateOne(emploiPrecedent);
	}

	@Override
	public List<EmploiPrecedent> listEmploiPrecedents() {
		return this.daoEmploiPrecedent.listAll();
	}
	
	@Override
	public List<EmploiPrecedent> listEmploiPrecedentsEmploye(Employe employe) {
		return this.daoEmploiPrecedent.listAllEmploye(employe);
	}	
}
