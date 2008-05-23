package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Inscription;
import entities.InscriptionPK;

public class DaoInscription implements IDaoInscription {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Inscription inscription) {
		em.persist(inscription);
	}

	@Override
	public void deleteOne(Inscription inscription) {
		Inscription i = em.find(Inscription.class, inscription.getPk());
		if (i != null)
			em.remove(i);
	}

	@Override
	public Inscription getOne(InscriptionPK pk) {
		return em.find(Inscription.class, pk);
	}

	@Override
	public void updateOne(Inscription inscription) {		
		em.merge(inscription);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Inscription> listAll() {
		Query q = em.createQuery("from Inscription");
		return (List<Inscription>) q.getResultList();
	}	
}
