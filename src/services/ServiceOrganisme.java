package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoOrganisme;

import entities.Organisme;

@Transactional
public class ServiceOrganisme implements IServiceOrganisme {
	// Couche [dao]
	private IDaoOrganisme daoOrganisme;

	@Override
	public void addOrganisme(Organisme orga) {
		this.daoOrganisme.addOne(orga);		
	}

	@Override
	public void deleteOrganisme(Organisme orga) {
		this.daoOrganisme.deleteOne(orga);		
	}

	@Override
	public Organisme getOrganisme(int id) {
		return this.daoOrganisme.getOne(id);
	}

	@Override
	public List<Organisme> listOrganismes() {
		return this.daoOrganisme.listAll();
	}

	@Override
	public void updateOrganisme(Organisme orga) {
		this.daoOrganisme.updateOne(orga);
	}

	public IDaoOrganisme getDaoOrganisme() {
		return daoOrganisme;
	}

	public void setDaoOrganisme(IDaoOrganisme daoOrganisme) {
		this.daoOrganisme = daoOrganisme;
	}	
}
