package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="COMPETENCE")
public class Competence implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_COMPETENCE")
	@SequenceGenerator(name="SEQ_COMPETENCE", sequenceName = "SEQ_COMPETENCE")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;
	
	private static final long serialVersionUID = 1L;

	public Competence() {
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
}
