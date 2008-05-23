package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoInscription;

import entities.Inscription;
import entities.InscriptionPK;

@Transactional
public class ServiceInscription implements IServiceInscription {
	// Couche [dao]
	private IDaoInscription daoInscription;

	@Override
	public void addInscription(Inscription inscription) {
		this.daoInscription.addOne(inscription);		
	}

	@Override
	public void deleteInscription(Inscription inscription) {
		this.daoInscription.deleteOne(inscription);		
	}

	@Override
	public Inscription getInscription(InscriptionPK pk) {
		return this.daoInscription.getOne(pk);
	}

	@Override
	public List<Inscription> listInscriptions() {
		return this.daoInscription.listAll();
	}

	@Override
	public void updateInscription(Inscription inscription) {
		this.daoInscription.updateOne(inscription);
	}

	public IDaoInscription getDaoInscription() {
		return daoInscription;
	}

	public void setDaoInscription(IDaoInscription daoInscription) {
		this.daoInscription = daoInscription;
	}	
}
