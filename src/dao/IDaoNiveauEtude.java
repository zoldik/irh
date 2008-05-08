package dao;

import java.util.List;

import entities.NiveauEtude;

public interface IDaoNiveauEtude {
	NiveauEtude getOne(int id);
	void addOne(NiveauEtude cat);
	void updateOne(NiveauEtude cat);
	void deleteOne(NiveauEtude cat);
	List<NiveauEtude> listAll();
}
