package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Diplome;
import entities.Employe;

public class DaoDiplome implements IDaoDiplome {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Diplome diplome) {
		em.persist(diplome);
	}

	@Override
	public void deleteOne(Diplome diplome) {
		Diplome d = em.find(Diplome.class, diplome.getId());
		if (d != null)
			em.remove(d);
	}

	@Override
	public Diplome getOne(int id) {
		return em.find(Diplome.class, id);
	}

	@Override
	public void updateOne(Diplome diplome) {		
		em.merge(diplome);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Diplome> listAll() {
		Query q = em.createQuery("from Diplome order by annee");
		return (List<Diplome>) q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Diplome> listAllEmploye(Employe employe) {
		Query q = em.createQuery("from Diplome where employe.id = :employeId order by annee desc");
		q.setParameter("employeId", employe.getId());
		return (List<Diplome>) q.getResultList();
	}
}
