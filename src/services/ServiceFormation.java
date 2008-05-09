package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoFormation;

import entities.Formation;

@Transactional
public class ServiceFormation implements IServiceFormation {
	// Couche [dao]
	private IDaoFormation daoFormation;

	@Override
	public void addFormation(Formation formation) {
		this.daoFormation.addOne(formation);		
	}

	@Override
	public void deleteFormation(Formation formation) {
		this.daoFormation.deleteOne(formation);		
	}

	@Override
	public Formation getFormation(int id) {
		return this.daoFormation.getOne(id);
	}

	@Override
	public List<Formation> listFormations() {
		return this.daoFormation.listAll();
	}

	@Override
	public void updateFormation(Formation formation) {
		this.daoFormation.updateOne(formation);
	}

	public IDaoFormation getDaoFormation() {
		return daoFormation;
	}

	public void setDaoFormation(IDaoFormation daoFormation) {
		this.daoFormation = daoFormation;
	}	
}
