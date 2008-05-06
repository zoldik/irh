package services;

import java.util.List;

import entities.Categorie;

public interface IServiceCategorie {
	Categorie getCategorie(int id);
	void addCategorie(Categorie cat);
	void updateCategorie(Categorie cat);
	void deleteCategorie(Categorie cat);
	List<Categorie> listCategories();
}
