package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="FORMATION")
public class Formation implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_FORMATION")
	@SequenceGenerator(name="SEQ_FORMATION", sequenceName = "SEQ_FORMATION")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;
	
	@Column(name="PRIX_PAR_PERSONNE")
	private double prixParPersonne;
	
	@Column(name="DUREE")
	private double duree;
	
	@ManyToOne
	@JoinColumn(name="ID_ORGANISME")
	private Organisme organisme;
	
	@OneToMany(mappedBy="formation")
	private Set<SessionFormation> sessionFormationCollection;
	
	private static final long serialVersionUID = 1L;

	public Formation() {
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

	public double getPrixParPersonne() {
		return prixParPersonne;
	}

	public void setPrixParPersonne(double prixParPersonne) {
		this.prixParPersonne = prixParPersonne;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}
	
	@Override
	public String toString() {
		return this.organisme.getNom() + " > " + this.libelle;
	}

	public Organisme getOrganisme() {
		return organisme;
	}

	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	public Set<SessionFormation> getSessionFormationCollection() {
		return sessionFormationCollection;
	}

	public void setSessionFormationCollection(
			Set<SessionFormation> sessionFormationCollection) {
		this.sessionFormationCollection = sessionFormationCollection;
	}
}
