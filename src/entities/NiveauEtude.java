package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="NIVEAU_ETUDE")
public class NiveauEtude implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(generator="SEQ_NIVEAU_ETUDE")
	@SequenceGenerator(name="SEQ_NIVEAU_ETUDE", sequenceName = "SEQ_NIVEAU_ETUDE")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;
	
	@OneToMany(mappedBy="niveau")
	private Set<Diplome> diplomeCollection;

	private static final long serialVersionUID = 1L;

	public NiveauEtude() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Diplome> getDiplomeCollection() {
		return diplomeCollection;
	}

	public void setDiplomeCollection(Set<Diplome> diplomeCollection) {
		this.diplomeCollection = diplomeCollection;
	}
	
	@Override
	public String toString() {
		return this.libelle;
	}
}
