package services;

import java.util.List;

import entities.Organisme;

public interface IServiceOrganisme {
	Organisme getOrganisme(int id);
	void addOrganisme(Organisme orga);
	void updateOrganisme(Organisme orga);
	void deleteOrganisme(Organisme orga);
	List<Organisme> listOrganismes();
}
