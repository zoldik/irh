package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Formation;

public class DaoFormation implements IDaoFormation {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Formation formation) {
		em.persist(formation);
	}

	@Override
	public void deleteOne(Formation formation) {
		Formation f = em.find(Formation.class, formation.getId());
		if (f != null)
			em.remove(f);
	}

	@Override
	public Formation getOne(int id) {
		return em.find(Formation.class, id);
	}

	@Override
	public void updateOne(Formation formation) {		
		em.merge(formation);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Formation> listAll() {
		Query q = em.createQuery("from Formation order by libelle");
		return (List<Formation>) q.getResultList();
	}	
}
