package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="CATEGORIE") 
public class Categorie implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_CATEGORIE")
	@SequenceGenerator(name="SEQ_CATEGORIE", sequenceName = "SEQ_CATEGORIE")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;

	@ManyToOne
	@JoinColumn(name="ID_THEME")
	private Theme theme;

	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
