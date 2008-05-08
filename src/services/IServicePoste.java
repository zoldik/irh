package services;

import java.util.List;

import entities.Poste;

public interface IServicePoste {
	Poste getPoste(int id);
	void addPoste(Poste poste);
	void updatePoste(Poste poste);
	void deletePoste(Poste poste);
	List<Poste> listPostes();
}
