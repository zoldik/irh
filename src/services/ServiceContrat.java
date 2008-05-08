package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoContrat;
import entities.Contrat;

@Transactional
public class ServiceContrat implements IServiceContrat {
	// Couche [dao]
	private IDaoContrat daoContrat;
	
	public IDaoContrat getDaoContrat() {
		return daoContrat;
	}

	public void setDaoContrat(IDaoContrat daoContrat) {
		this.daoContrat = daoContrat;
	}

	@Override
	public void addContrat(Contrat contrat) {
		this.daoContrat.addOne(contrat);		
	}

	@Override
	public void deleteContrat(Contrat contrat) {
		this.daoContrat.deleteOne(contrat);		
	}

	@Override
	public Contrat getContrat(int id) {
		return this.daoContrat.getOne(id);
	}

	@Override
	public List<Contrat> listContrats() {
		return this.daoContrat.listAll();
	}

	@Override
	public void updateContrat(Contrat contrat) {
		this.daoContrat.updateOne(contrat);
	}
}
