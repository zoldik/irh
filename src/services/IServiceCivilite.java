package services;

import java.util.List;

import entities.Civilite;

public interface IServiceCivilite {
	Civilite getCivilite(int id);
	void addCivilite(Civilite cat);
	void updateCivilite(Civilite cat);
	void deleteCivilite(Civilite cat);
	List<Civilite> listCivilites();
}
