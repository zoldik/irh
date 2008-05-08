package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Poste;

public class DaoPoste implements IDaoPoste {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Poste poste) {
		em.persist(poste);
	}

	@Override
	public void deleteOne(Poste poste) {
		Poste p = em.find(Poste.class, poste.getId());
		if (p != null)
			em.remove(p);
	}

	@Override
	public Poste getOne(int id) {
		return em.find(Poste.class, id);
	}

	@Override
	public void updateOne(Poste poste) {		
		em.merge(poste);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Poste> listAll() {
		Query q = em.createQuery("from Poste order by libelle");
		return (List<Poste>) q.getResultList();
	}	
}
