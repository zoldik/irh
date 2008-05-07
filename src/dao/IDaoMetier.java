package dao;

import java.util.List;

import entities.Metier;

public interface IDaoMetier {
	Metier getOne(int id);
	void addOne(Metier metier);
	void updateOne(Metier metier);
	void deleteOne(Metier metier);
	List<Metier> listAll();
}
