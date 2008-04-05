package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Utilisateur;

public class DaoUtilisateur implements IDaoUtilisateur {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addOne(Utilisateur user) {
		em.persist(user);
	}

	@Override
	public void deleteOne(Utilisateur user) {
		Utilisateur u = em.find(Utilisateur.class, user.getId());
		if (u != null)
			em.remove(user);
	}

	@Override
	public Utilisateur getOne(int id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public void updateOne(Utilisateur user) {
		Utilisateur u = em.find(Utilisateur.class, user.getId());
		if (u != null) {
			u.setNom(user.getNom());
			u.setLogin(user.getLogin());
			u.setPass(user.getPass());
			u.setIdDroit(user.getIdDroit());
		}
	}

}
