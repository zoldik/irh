package dao;

import java.util.List;

import entities.SessionFormation;

public interface IDaoSessionFormation {
	SessionFormation getOne(int id);
	void addOne(SessionFormation session);
	void updateOne(SessionFormation session);
	void deleteOne(SessionFormation session);
	List<SessionFormation> listAll();
}
