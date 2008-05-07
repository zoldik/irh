package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Competence;

public class DaoCompetence implements IDaoCompetence {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Competence comp) {
		em.persist(comp);
	}

	@Override
	public void deleteOne(Competence comp) {
		Competence c = em.find(Competence.class, comp.getId());
		if (c != null)
			em.remove(c);
	}

	@Override
	public Competence getOne(int id) {
		return em.find(Competence.class, id);
	}

	@Override
	public void updateOne(Competence comp) {		
		em.merge(comp);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Competence> listAll() {
		Query q = em.createQuery("from Competence order by libelle");
		return (List<Competence>) q.getResultList();
	}	
}
