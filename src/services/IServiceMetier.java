package services;

import java.util.List;

import entities.Metier;

public interface IServiceMetier {
	Metier getMetier(int id);
	void addMetier(Metier metier);
	void updateMetier(Metier metier);
	void deleteMetier(Metier metier);
	List<Metier> listMetiers();
}
