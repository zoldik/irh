package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoSituationFamiliale;
import entities.SituationFamiliale;

@Transactional
public class ServiceSituationFamiliale implements IServiceSituationFamiliale {
	// Couche [dao]
	private IDaoSituationFamiliale daoSituationFamiliale;
	
	public IDaoSituationFamiliale getDaoSituationFamiliale() {
		return daoSituationFamiliale;
	}

	public void setDaoSituationFamiliale(IDaoSituationFamiliale daoSituationFamiliale) {
		this.daoSituationFamiliale = daoSituationFamiliale;
	}

	@Override
	public void addSituationFamiliale(SituationFamiliale civilite) {
		this.daoSituationFamiliale.addOne(civilite);		
	}

	@Override
	public void deleteSituationFamiliale(SituationFamiliale civilite) {
		this.daoSituationFamiliale.deleteOne(civilite);		
	}

	@Override
	public SituationFamiliale getSituationFamiliale(int id) {
		return this.daoSituationFamiliale.getOne(id);
	}

	@Override
	public List<SituationFamiliale> listSituationsFamiliale() {
		return this.daoSituationFamiliale.listAll();
	}

	@Override
	public void updateSituationFamiliale(SituationFamiliale civilite) {
		this.daoSituationFamiliale.updateOne(civilite);
	}
}
