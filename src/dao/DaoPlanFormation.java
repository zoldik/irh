package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.PlanFormation;

public class DaoPlanFormation implements IDaoPlanFormation {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(PlanFormation plan) {
		em.persist(plan);
	}

	@Override
	public void deleteOne(PlanFormation plan) {
		PlanFormation p = em.find(PlanFormation.class, plan.getId());
		if (p != null)
			em.remove(p);
	}

	@Override
	public PlanFormation getOne(int id) {
		return em.find(PlanFormation.class, id);
	}

	@Override
	public void updateOne(PlanFormation plan) {		
		em.merge(plan);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PlanFormation> listAll() {
		Query q = em.createQuery("from PlanFormation order by annee");
		return (List<PlanFormation>) q.getResultList();
	}	
}
