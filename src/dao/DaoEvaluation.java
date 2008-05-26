package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Evaluation;;

public class DaoEvaluation implements IDaoEvaluation {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Evaluation evaluation) {
		em.persist(evaluation);
	}

	@Override
	public void deleteOne(Evaluation evaluation) {
		Evaluation e = em.find(Evaluation.class, evaluation.getId());
		if (e != null)
			em.remove(e);
	}

	@Override
	public Evaluation getOne(int id) {
		return em.find(Evaluation.class, id);
	}

	@Override
	public void updateOne(Evaluation evaluation) {		
		em.merge(evaluation);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Evaluation> listAll() {
		Query q = em.createQuery("from Evaluation order by dateEvaluation");
		return (List<Evaluation>) q.getResultList();
	}	
}
