package services;

import java.util.List;

import entities.SituationFamiliale;

public interface IServiceSituationFamiliale {
	SituationFamiliale getSituationFamiliale(int id);
	void addSituationFamiliale(SituationFamiliale sitFam);
	void updateSituationFamiliale(SituationFamiliale sitFam);
	void deleteSituationFamiliale(SituationFamiliale sitFam);
	List<SituationFamiliale> listSituationsFamiliale();
}
