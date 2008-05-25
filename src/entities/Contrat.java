package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CONTRAT")
public class Contrat implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_CONTRAT")
	@SequenceGenerator(name="SEQ_CONTRAT", sequenceName = "SEQ_CONTRAT")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;
	
	@OneToMany(mappedBy="contrat")
	private Set<EmploiPrecedent> EmploiPrecedentCollection;

	private static final long serialVersionUID = 1L;

	public Contrat() {
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

	public Set<EmploiPrecedent> getEmploiPrecedentCollection() {
		return EmploiPrecedentCollection;
	}

	public void setEmploiPrecedentCollection(
			Set<EmploiPrecedent> emploiPrecedentCollection) {
		EmploiPrecedentCollection = emploiPrecedentCollection;
	}
	
	@Override
	public String toString() {
		return this.libelle;
	}

}
