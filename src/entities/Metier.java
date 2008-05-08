package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="METIER") 
public class Metier implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_METIER")
	@SequenceGenerator(name="SEQ_METIER", sequenceName = "SEQ_METIER")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;

	@ManyToOne
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie;
	
	@OneToMany(mappedBy="metier")
	private Set<Poste> posteCollection;

	private static final long serialVersionUID = 1L;

	public Metier() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Set<Poste> getPosteCollection() {
		return posteCollection;
	}

	public void setPosteCollection(Set<Poste> posteCollection) {
		this.posteCollection = posteCollection;
	}

	@Override
	public String toString() {
		return this.categorie.toString() + " > " + this.libelle;
	}
	
	
}
