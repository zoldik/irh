package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoPoste;

import entities.Poste;

@Transactional
public class ServicePoste implements IServicePoste {
	// Couche [dao]
	private IDaoPoste daoPoste;

	@Override
	public void addPoste(Poste poste) {
		this.daoPoste.addOne(poste);		
	}

	@Override
	public void deletePoste(Poste poste) {
		this.daoPoste.deleteOne(poste);		
	}

	@Override
	public Poste getPoste(int id) {
		return this.daoPoste.getOne(id);
	}

	@Override
	public List<Poste> listPostes() {
		return this.daoPoste.listAll();
	}

	@Override
	public void updatePoste(Poste poste) {
		this.daoPoste.updateOne(poste);
	}

	public IDaoPoste getDaoPoste() {
		return daoPoste;
	}

	public void setDaoPoste(IDaoPoste daoPoste) {
		this.daoPoste = daoPoste;
	}	
}
