package dao;

import java.util.List;

import entities.NiveauForm;
import entities.NiveauFormPK;

public interface IDaoNiveauForm {
	NiveauForm getOne(NiveauFormPK pk);
	void addOne(NiveauForm niveauForm);
	void updateOne(NiveauForm niveauForm);
	void deleteOne(NiveauForm niveauForm);
	List<NiveauForm> listAll();
}
