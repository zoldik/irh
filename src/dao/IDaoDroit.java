package dao;

import java.util.List;

import entities.Droit;

public interface IDaoDroit {
	Droit getOne(int id);
	void addOne(Droit droit);
	void updateOne(Droit droit);
	void deleteOne(Droit droit);
	List<Droit> listAll();
}
