package dao;

import java.util.List;

import entities.Categorie;

public interface IDaoCategorie {
	Categorie getOne(int id);
	void addOne(Categorie cat);
	void updateOne(Categorie cat);
	void deleteOne(Categorie cat);
	List<Categorie> listAll();
}
