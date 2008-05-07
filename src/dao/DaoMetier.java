package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Metier;

public class DaoMetier implements IDaoMetier {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Metier metier) {
		em.persist(metier);
	}

	@Override
	public void deleteOne(Metier metier) {
		Metier m = em.find(Metier.class, metier.getId());
		if (m != null)
			em.remove(m);
	}

	@Override
	public Metier getOne(int id) {
		return em.find(Metier.class, id);
	}

	@Override
	public void updateOne(Metier metier) {		
		em.merge(metier);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Metier> listAll() {
		Query q = em.createQuery("from Metier order by libelle");
		return (List<Metier>) q.getResultList();
	}	
}
