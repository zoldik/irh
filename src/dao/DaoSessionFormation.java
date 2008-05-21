package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.SessionFormation;

public class DaoSessionFormation implements IDaoSessionFormation {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(SessionFormation session) {
		em.persist(session);
	}

	@Override
	public void deleteOne(SessionFormation session) {
		SessionFormation s = em.find(SessionFormation.class, session.getId());
		if (s != null)
			em.remove(s);
	}

	@Override
	public SessionFormation getOne(int id) {
		return em.find(SessionFormation.class, id);
	}

	@Override
	public void updateOne(SessionFormation session) {		
		em.merge(session);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SessionFormation> listAll() {
		Query q = em.createQuery("from SessionFormation order by dateDebut");
		return (List<SessionFormation>) q.getResultList();
	}	
}
