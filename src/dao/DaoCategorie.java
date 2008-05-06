package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Categorie;

public class DaoCategorie implements IDaoCategorie {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Categorie cat) {
		em.persist(cat);
	}

	@Override
	public void deleteOne(Categorie cat) {
		Categorie c = em.find(Categorie.class, cat.getId());
		if (c != null)
			em.remove(c);
	}

	@Override
	public Categorie getOne(int id) {
		return em.find(Categorie.class, id);
	}

	@Override
	public void updateOne(Categorie cat) {		
		em.merge(cat);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categorie> listAll() {
		Query q = em.createQuery("from Categorie order by libelle");
		return (List<Categorie>) q.getResultList();
	}	
}
