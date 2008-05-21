package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoSessionFormation;

import entities.SessionFormation;

@Transactional
public class ServiceSessionFormation implements IServiceSessionFormation {
	// Couche [dao]
	private IDaoSessionFormation daoSessionFormation;
	
	@Override
	public void addSessionFormation(SessionFormation session) {
		this.daoSessionFormation.addOne(session);		
	}

	@Override
	public void deleteSessionFormation(SessionFormation session) {
		this.daoSessionFormation.deleteOne(session);		
	}

	@Override
	public SessionFormation getSessionFormation(int id) {
		return this.daoSessionFormation.getOne(id);
	}

	@Override
	public List<SessionFormation> listSessionFormations() {
		return this.daoSessionFormation.listAll();
	}

	@Override
	public void updateSessionFormation(SessionFormation session) {
		this.daoSessionFormation.updateOne(session);
	}

	public IDaoSessionFormation getDaoSessionFormation() {
		return daoSessionFormation;
	}

	public void setDaoSessionFormation(IDaoSessionFormation daoSessionFormation) {
		this.daoSessionFormation = daoSessionFormation;
	}	
}
