package services;

import java.util.List;

import entities.NiveauEtude;

public interface IServiceNiveauEtude {
	NiveauEtude getNiveauEtude(int id);
	void addNiveauEtude(NiveauEtude niveauEtude);
	void updateNiveauEtude(NiveauEtude niveauEtude);
	void deleteNiveauEtude(NiveauEtude niveauEtude);
	List<NiveauEtude> listNiveauxEtude();
}
