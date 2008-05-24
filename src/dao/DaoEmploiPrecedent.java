package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.EmploiPrecedent;
import entities.Employe;

public class DaoEmploiPrecedent implements IDaoEmploiPrecedent {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(EmploiPrecedent emploiPrecedent) {
		em.persist(emploiPrecedent);
	}

	@Override
	public void deleteOne(EmploiPrecedent emploiPrecedent) {
		EmploiPrecedent d = em.find(EmploiPrecedent.class, emploiPrecedent.getId());
		if (d != null)
			em.remove(d);
	}

	@Override
	public EmploiPrecedent getOne(int id) {
		return em.find(EmploiPrecedent.class, id);
	}

	@Override
	public void updateOne(EmploiPrecedent emploiPrecedent) {		
		em.merge(emploiPrecedent);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EmploiPrecedent> listAll() {
		Query q = em.createQuery("from EmploiPrecedent order by date_debut");
		return (List<EmploiPrecedent>) q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<EmploiPrecedent> listAllEmploye(Employe employe) {
		Query q = em.createQuery("from EmploiPrecedent where employe.id = :employeId order by date_debut desc");
		q.setParameter("employeId", employe.getId());
		return (List<EmploiPrecedent>) q.getResultList();
	}
}
