package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoEvaluation;

import entities.Evaluation;

@Transactional
public class ServiceEvaluation implements IServiceEvaluation {
	// Couche [dao]
	private IDaoEvaluation daoEvaluation;

	@Override
	public void addEvaluation(Evaluation evaluation) {
		this.daoEvaluation.addOne(evaluation);		
	}

	@Override
	public void deleteEvaluation(Evaluation evaluation) {
		this.daoEvaluation.deleteOne(evaluation);		
	}

	@Override
	public Evaluation getEvaluation(int id) {
		return this.daoEvaluation.getOne(id);
	}

	@Override
	public List<Evaluation> listEvaluations() {
		return this.daoEvaluation.listAll();
	}

	@Override
	public void updateEvaluation(Evaluation evaluation) {
		this.daoEvaluation.updateOne(evaluation);
	}

	public IDaoEvaluation getDaoEvaluation() {
		return daoEvaluation;
	}

	public void setDaoEvaluation(IDaoEvaluation daoEvaluation) {
		this.daoEvaluation = daoEvaluation;
	}	
}
