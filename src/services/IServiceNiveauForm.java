package services;

import java.util.List;

import entities.NiveauForm;
import entities.NiveauFormPK;

public interface IServiceNiveauForm {
	NiveauForm getNiveauForm(NiveauFormPK pk);
	void addNiveauForm(NiveauForm niveauForm);
	void updateNiveauForm(NiveauForm niveauForm);
	void deleteNiveauForm(NiveauForm niveauForm);
	List<NiveauForm> listNiveauForms();
}
