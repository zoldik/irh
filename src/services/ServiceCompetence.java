package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoCompetence;

import entities.Competence;

@Transactional
public class ServiceCompetence implements IServiceCompetence {
	// Couche [dao]
	private IDaoCompetence daoCompetence;

	@Override
	public void addCompetence(Competence comp) {
		this.daoCompetence.addOne(comp);		
	}

	@Override
	public void deleteCompetence(Competence comp) {
		this.daoCompetence.deleteOne(comp);		
	}

	@Override
	public Competence getCompetence(int id) {
		return this.daoCompetence.getOne(id);
	}

	@Override
	public List<Competence> listCompetences() {
		return this.daoCompetence.listAll();
	}

	@Override
	public void updateCompetence(Competence comp) {
		this.daoCompetence.updateOne(comp);
	}

	public IDaoCompetence getDaoCompetence() {
		return daoCompetence;
	}

	public void setDaoCompetence(IDaoCompetence daoCompetence) {
		this.daoCompetence = daoCompetence;
	}	
}
