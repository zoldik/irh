package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="ORGANISME")
public class Organisme implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_ORGANISME")
	@SequenceGenerator(name="SEQ_ORGANISME", sequenceName = "SEQ_ORGANISME")
	private int id;

	@Column(name="NOM")
	private String nom;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="organisme")
	private Set<Formation> formationCollection;
	
	private static final long serialVersionUID = 1L;

	public Organisme() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

	public Set<Formation> getFormationCollection() {
		return formationCollection;
	}

	public void setFormationCollection(Set<Formation> formationCollection) {
		this.formationCollection = formationCollection;
	}
}
