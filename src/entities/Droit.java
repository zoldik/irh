package entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="DROIT")
public class Droit implements Serializable {
	@Id
	@Column(name="ID")
	private long id;

	@Column(name="LIBELLE")
	private String libelle;

	@OneToMany(mappedBy="idDroit")
	private Set<Utilisateur> utilisateurCollection;

	private static final long serialVersionUID = 1L;

	public Droit() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Utilisateur> getUtilisateurCollection() {
		return this.utilisateurCollection;
	}

	public void setUtilisateurCollection(Set<Utilisateur> utilisateurCollection) {
		this.utilisateurCollection = utilisateurCollection;
	}

}
