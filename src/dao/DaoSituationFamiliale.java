package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.SituationFamiliale;

public class DaoSituationFamiliale implements IDaoSituationFamiliale {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(SituationFamiliale sitFam) {
		em.persist(sitFam);
	}

	@Override
	public void deleteOne(SituationFamiliale sitFam) {
		SituationFamiliale c = em.find(SituationFamiliale.class, sitFam.getId());
		if (c != null)
			em.remove(c);
	}

	@Override
	public SituationFamiliale getOne(int id) {
		return em.find(SituationFamiliale.class, id);
	}

	@Override
	public void updateOne(SituationFamiliale sitFam) {		
		em.merge(sitFam);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SituationFamiliale> listAll() {
		Query q = em.createQuery("from SituationFamiliale order by libelle");
		return (List<SituationFamiliale>) q.getResultList();
	}

}
