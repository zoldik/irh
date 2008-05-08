package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Employe;

public class DaoEmploye implements IDaoEmploye {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Employe employe) {
		em.persist(employe);
	}

	@Override
	public void deleteOne(Employe employe) {
		Employe e = em.find(Employe.class, employe.getId());
		if (e != null)
			em.remove(employe);
	}

	@Override
	public Employe getOne(int id) {
		return em.find(Employe.class, id);
	}

	@Override
	public void updateOne(Employe employe) {		
		em.merge(employe);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employe> listAll() {
		Query q = em.createQuery("from Employe order by libelle");
		return (List<Employe>) q.getResultList();
	}	
}
