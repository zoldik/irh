package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.NiveauForm;
import entities.NiveauFormPK;

public class DaoNiveauForm implements IDaoNiveauForm {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(NiveauForm niveauForm) {
		em.persist(niveauForm);
	}

	@Override
	public void deleteOne(NiveauForm niveauForm) {
		NiveauForm n = em.find(NiveauForm.class, niveauForm.getPk());
		if (n != null)
			em.remove(n);
	}

	@Override
	public NiveauForm getOne(NiveauFormPK pk) {
		return em.find(NiveauForm.class, pk);
	}

	@Override
	public void updateOne(NiveauForm niveauForm) {		
		em.merge(niveauForm);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<NiveauForm> listAll() {
		Query q = em.createQuery("from NiveauForm");
		return (List<NiveauForm>) q.getResultList();
	}	
}
