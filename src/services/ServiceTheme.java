package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoTheme;

import entities.Theme;

@Transactional
public class ServiceTheme implements IServiceTheme {
	// Couche [dao]
	private IDaoTheme daoTheme;
	
	public IDaoTheme getDaoTheme() {
		return daoTheme;
	}

	public void setDaoTheme(IDaoTheme daoTheme) {
		this.daoTheme = daoTheme;
	}

	@Override
	public void addTheme(Theme theme) {
		this.daoTheme.addOne(theme);		
	}

	@Override
	public void deleteTheme(Theme theme) {
		this.daoTheme.deleteOne(theme);		
	}

	@Override
	public Theme getTheme(int id) {
		return this.daoTheme.getOne(id);
	}

	@Override
	public List<Theme> listThemes() {
		return this.daoTheme.listAll();
	}

	@Override
	public void updateTheme(Theme theme) {
		this.daoTheme.updateOne(theme);
	}	
}
