package services;

import java.util.List;

import entities.Inscription;
import entities.InscriptionPK;

public interface IServiceInscription {
	Inscription getInscription(InscriptionPK pk);
	void addInscription(Inscription inscription);
	void updateInscription(Inscription inscription);
	void deleteInscription(Inscription inscription);
	List<Inscription> listInscriptions();
}
