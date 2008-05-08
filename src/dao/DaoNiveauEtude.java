package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.NiveauEtude;

public class DaoNiveauEtude implements IDaoNiveauEtude {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(NiveauEtude niveauEtude) {
		em.persist(niveauEtude);
	}

	@Override
	public void deleteOne(NiveauEtude niveauEtude) {
		NiveauEtude ne = em.find(NiveauEtude.class, niveauEtude.getId());
		if (ne != null)
			em.remove(ne);
	}

	@Override
	public NiveauEtude getOne(int id) {
		return em.find(NiveauEtude.class, id);
	}

	@Override
	public void updateOne(NiveauEtude niveauEtude) {		
		em.merge(niveauEtude);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<NiveauEtude> listAll() {
		Query q = em.createQuery("from NiveauEtude order by libelle");
		return (List<NiveauEtude>) q.getResultList();
	}	
}
