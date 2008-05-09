package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Organisme;

public class DaoOrganisme implements IDaoOrganisme {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Organisme orga) {
		em.persist(orga);
	}

	@Override
	public void deleteOne(Organisme orga) {
		Organisme o = em.find(Organisme.class, orga.getId());
		if (o != null)
			em.remove(o);
	}

	@Override
	public Organisme getOne(int id) {
		return em.find(Organisme.class, id);
	}

	@Override
	public void updateOne(Organisme orga) {		
		em.merge(orga);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Organisme> listAll() {
		Query q = em.createQuery("from Organisme order by nom");
		return (List<Organisme>) q.getResultList();
	}	
}
