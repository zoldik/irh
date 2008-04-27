package services;

import java.util.List;

import entities.Droit;

public interface IServiceDroit {
	Droit getDroit(int id);
	void addDroit(Droit droit);
	void updateDroit(Droit droit);
	void deleteDroit(Droit droit);
	List<Droit> listDroits();
}
