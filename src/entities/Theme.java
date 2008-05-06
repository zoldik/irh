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
@Table(name="THEME")
public class Theme implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_THEME")
	@SequenceGenerator(name="SEQ_THEME", sequenceName = "SEQ_THEME")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;

	@OneToMany(mappedBy="theme")
	private Set<Categorie> categorieCollection;
	
	private static final long serialVersionUID = 1L;

	public Theme() {
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
	
	@Override
	public String toString() {
		return this.libelle;
	}

	public Set<Categorie> getCategorieCollection() {
		return categorieCollection;
	}

	public void setCategorieCollection(Set<Categorie> categorieCollection) {
		this.categorieCollection = categorieCollection;
	}
}
