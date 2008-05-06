package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoCategorie;

import entities.Categorie;

@Transactional
public class ServiceCategorie implements IServiceCategorie {
	// Couche [dao]
	private IDaoCategorie daoCategorie;

	@Override
	public void addCategorie(Categorie cat) {
		this.daoCategorie.addOne(cat);		
	}

	@Override
	public void deleteCategorie(Categorie cat) {
		this.daoCategorie.deleteOne(cat);		
	}

	@Override
	public Categorie getCategorie(int id) {
		return this.daoCategorie.getOne(id);
	}

	@Override
	public List<Categorie> listCategories() {
		return this.daoCategorie.listAll();
	}

	@Override
	public void updateCategorie(Categorie cat) {
		this.daoCategorie.updateOne(cat);
	}

	public IDaoCategorie getDaoCategorie() {
		return daoCategorie;
	}

	public void setDaoCategorie(IDaoCategorie daoCategorie) {
		this.daoCategorie = daoCategorie;
	}	
}
