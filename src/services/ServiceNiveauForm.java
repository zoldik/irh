package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoNiveauForm;

import entities.NiveauForm;
import entities.NiveauFormPK;

@Transactional
public class ServiceNiveauForm implements IServiceNiveauForm {
	// Couche [dao]
	private IDaoNiveauForm daoNiveauForm;
	
	public IDaoNiveauForm getDaoNiveauForm() {
		return daoNiveauForm;
	}

	public void setDaoNiveauForm(IDaoNiveauForm daoNiveauForm) {
		this.daoNiveauForm = daoNiveauForm;
	}

	@Override
	public void addNiveauForm(NiveauForm niveauForm) {
		this.daoNiveauForm.addOne(niveauForm);		
	}

	@Override
	public void deleteNiveauForm(NiveauForm niveauForm) {
		this.daoNiveauForm.deleteOne(niveauForm);		
	}

	@Override
	public NiveauForm getNiveauForm(NiveauFormPK pk) {
		return this.daoNiveauForm.getOne(pk);
	}

	@Override
	public List<NiveauForm> listNiveauForms() {
		return this.daoNiveauForm.listAll();
	}

	@Override
	public void updateNiveauForm(NiveauForm niveauForm) {
		this.daoNiveauForm.updateOne(niveauForm);
	}	
}
