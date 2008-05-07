package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Civilite;

public class DaoCivilite implements IDaoCivilite {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Civilite civilite) {
		em.persist(civilite);
	}

	@Override
	public void deleteOne(Civilite civilite) {
		Civilite c = em.find(Civilite.class, civilite.getId());
		if (c != null)
			em.remove(c);
	}

	@Override
	public Civilite getOne(int id) {
		return em.find(Civilite.class, id);
	}

	@Override
	public void updateOne(Civilite civilite) {		
		em.merge(civilite);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Civilite> listAll() {
		Query q = em.createQuery("from Civilite order by libelle");
		return (List<Civilite>) q.getResultList();
	}
}
