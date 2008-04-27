package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoDroit;

import entities.Droit;

@Transactional
public class ServiceDroit implements IServiceDroit {
	// Couche [dao]
	private IDaoDroit daoDroit;
	
	public IDaoDroit getDaoDroit() {
		return daoDroit;
	}

	public void setDaoDroit(IDaoDroit daoDroit) {
		this.daoDroit = daoDroit;
	}

	@Override
	public void addDroit(Droit droit) {
		this.daoDroit.addOne(droit);		
	}

	@Override
	public void deleteDroit(Droit droit) {
		this.daoDroit.deleteOne(droit);		
	}

	@Override
	public Droit getDroit(int id) {
		return this.daoDroit.getOne(id);
	}

	@Override
	public List<Droit> listDroits() {
		return this.daoDroit.listAll();
	}

	@Override
	public void updateDroit(Droit droit) {
		this.daoDroit.updateOne(droit);
	}	
}
