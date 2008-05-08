package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoNiveauEtude;
import entities.NiveauEtude;

@Transactional
public class ServiceNiveauEtude implements IServiceNiveauEtude {
	// Couche [dao]
	private IDaoNiveauEtude daoNiveauEtude;
	
	public IDaoNiveauEtude getDaoNiveauEtude() {
		return daoNiveauEtude;
	}

	public void setDaoNiveauEtude(IDaoNiveauEtude daoNiveauEtude) {
		this.daoNiveauEtude = daoNiveauEtude;
	}

	@Override
	public void addNiveauEtude(NiveauEtude niveauEtude) {
		this.daoNiveauEtude.addOne(niveauEtude);		
	}

	@Override
	public void deleteNiveauEtude(NiveauEtude niveauEtude) {
		this.daoNiveauEtude.deleteOne(niveauEtude);		
	}

	@Override
	public NiveauEtude getNiveauEtude(int id) {
		return this.daoNiveauEtude.getOne(id);
	}

	@Override
	public List<NiveauEtude> listNiveauxEtude() {
		return this.daoNiveauEtude.listAll();
	}

	@Override
	public void updateNiveauEtude(NiveauEtude niveauEtude) {
		this.daoNiveauEtude.updateOne(niveauEtude);
	}
}
