package services;

import java.util.List;

import entities.Evaluation;

public interface IServiceEvaluation {
	Evaluation getEvaluation(int id);
	void addEvaluation(Evaluation evaluation);
	void updateEvaluation(Evaluation evaluation);
	void deleteEvaluation(Evaluation evaluation);
	List<Evaluation> listEvaluations();
}
