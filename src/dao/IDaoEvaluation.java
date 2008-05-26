package dao;

import java.util.List;

import entities.Evaluation;;

public interface IDaoEvaluation {
	Evaluation getOne(int id);
	void addOne(Evaluation evaluation);
	void updateOne(Evaluation evaluation);
	void deleteOne(Evaluation evaluation);
	List<Evaluation> listAll();
}
