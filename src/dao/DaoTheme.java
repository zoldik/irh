package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Theme;

public class DaoTheme implements IDaoTheme {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Theme theme) {
		em.persist(theme);
	}

	@Override
	public void deleteOne(Theme theme) {
		Theme t = em.find(Theme.class, theme.getId());
		if (t != null)
			em.remove(t);
	}

	@Override
	public Theme getOne(int id) {
		return em.find(Theme.class, id);
	}

	@Override
	public void updateOne(Theme theme) {		
		em.merge(theme);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Theme> listAll() {
		Query q = em.createQuery("from Theme order by libelle");
		return (List<Theme>) q.getResultList();
	}	
}
