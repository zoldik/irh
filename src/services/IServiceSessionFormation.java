package services;

import java.util.List;

import entities.SessionFormation;

public interface IServiceSessionFormation {
	SessionFormation getSessionFormation(int id);
	void addSessionFormation(SessionFormation session);
	void updateSessionFormation(SessionFormation session);
	void deleteSessionFormation(SessionFormation session);
	List<SessionFormation> listSessionFormations();
}
