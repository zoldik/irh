package dao;

import java.util.List;

import entities.SituationFamiliale;

public interface IDaoSituationFamiliale {
	SituationFamiliale getOne(int id);
	void addOne(SituationFamiliale sitFam);
	void updateOne(SituationFamiliale sitFam);
	void deleteOne(SituationFamiliale sitFam);
	List<SituationFamiliale> listAll();
}
