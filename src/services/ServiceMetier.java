package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoMetier;

import entities.Metier;

@Transactional
public class ServiceMetier implements IServiceMetier {
	// Couche [dao]
	private IDaoMetier daoMetier;

	@Override
	public void addMetier(Metier metier) {
		this.daoMetier.addOne(metier);		
	}

	@Override
	public void deleteMetier(Metier metier) {
		this.daoMetier.deleteOne(metier);		
	}

	@Override
	public Metier getMetier(int id) {
		return this.daoMetier.getOne(id);
	}

	@Override
	public List<Metier> listMetiers() {
		return this.daoMetier.listAll();
	}

	@Override
	public void updateMetier(Metier metier) {
		this.daoMetier.updateOne(metier);
	}

	public IDaoMetier getDaoMetier() {
		return daoMetier;
	}

	public void setDaoMetier(IDaoMetier daoMetier) {
		this.daoMetier = daoMetier;
	}

}
