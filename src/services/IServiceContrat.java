package services;

import java.util.List;

import entities.Contrat;

public interface IServiceContrat {
	Contrat getContrat(int id);
	void addContrat(Contrat contrat);
	void updateContrat(Contrat contrat);
	void deleteContrat(Contrat contrat);
	List<Contrat> listContrats();
}
