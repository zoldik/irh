package services;

import java.util.List;

import dao.IDaoCivilite;
import entities.Civilite;

public class ServiceCivilite implements IServiceCivilite {
	// Couche [dao]
	private IDaoCivilite daoCivilite;
	
	public IDaoCivilite getDaoCivilite() {
		return daoCivilite;
	}

	public void setDaoCivilite(IDaoCivilite daoCivilite) {
		this.daoCivilite = daoCivilite;
	}

	@Override
	public void addCivilite(Civilite civilite) {
		this.daoCivilite.addOne(civilite);		
	}

	@Override
	public void deleteCivilite(Civilite civilite) {
		this.daoCivilite.deleteOne(civilite);		
	}

	@Override
	public Civilite getCivilite(int id) {
		return this.daoCivilite.getOne(id);
	}

	@Override
	public List<Civilite> listCivilites() {
		return this.daoCivilite.listAll();
	}

	@Override
	public void updateCivilite(Civilite civilite) {
		this.daoCivilite.updateOne(civilite);
	}
}
