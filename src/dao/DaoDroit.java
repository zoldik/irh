package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Droit;

public class DaoDroit implements IDaoDroit {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Droit droit) {
		em.persist(droit);
	}

	@Override
	public void deleteOne(Droit droit) {
		Droit d = em.find(Droit.class, droit.getId());
		if (d != null)
			em.remove(d);
	}

	@Override
	public Droit getOne(int id) {
		return em.find(Droit.class, id);
	}

	@Override
	public void updateOne(Droit droit) {		
		em.merge(droit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Droit> listAll() {
		Query q = em.createQuery("from Droit order by libelle");
		return (List<Droit>) q.getResultList();
	}	
}
