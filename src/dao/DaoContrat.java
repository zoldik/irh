package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Contrat;

public class DaoContrat implements IDaoContrat {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Contrat contrat) {
		em.persist(contrat);
	}

	@Override
	public void deleteOne(Contrat contrat) {
		Contrat c = em.find(Contrat.class, contrat.getId());
		if (c != null)
			em.remove(c);
	}

	@Override
	public Contrat getOne(int id) {
		return em.find(Contrat.class, id);
	}

	@Override
	public void updateOne(Contrat contrat) {		
		em.merge(contrat);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contrat> listAll() {
		Query q = em.createQuery("from Contrat order by libelle");
		return (List<Contrat>) q.getResultList();
	}

}
