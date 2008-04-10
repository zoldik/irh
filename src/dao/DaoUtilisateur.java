package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		/*Utilisateur u = em.find(Utilisateur.class, user.getId());
		if (u != null) {
			u.setNom(user.getNom());
			u.setLogin(user.getLogin());
			u.setPass(user.getPass());
			u.setDroit(user.getDroit());
		}*/
		
		em.merge(user);
	}
	
	@Override
	public boolean existe(Utilisateur user) {
		boolean existe = true;
		
		Query q = em.createQuery("from Utilisateur u " +
				"where u.login = :login " +
				"and u.pass = :pass ");
		
		q.setParameter("login", "ajarnoux");//user.getLogin());
		q.setParameter("pass", "irh");//user.getPass());
	
		//System.out.println("## existe: ");
		
		/*for (Utilisateur u : (List<Utilisateur>)q.getResultList()) {
			/*if(u.getLogin().equals(user.getLogin())) {
				System.out.println("c'est gagné !");
				existe = true;
			}*/
		/*	System.out.println(u.getLogin());
			System.out.println(u.getDroit().getLibelle());
		}*/
		
		try {
			Utilisateur u = (Utilisateur) q.getSingleResult();
		
			System.out.println("## existe: " + u.getLogin() + " trouvé.");
		} catch (NoResultException e) {
			existe = false;
			System.out.println("existe : dans le catch");
		}
		
		return existe;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Utilisateur> listAll() {
		Query q = em.createQuery("from Utilisateur");
		return (List<Utilisateur>) q.getResultList();
	}
}
