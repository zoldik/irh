package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="POSTE")
public class Poste implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_POSTE")
	@SequenceGenerator(name="SEQ_POSTE", sequenceName = "SEQ_POSTE")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;

	@Column(name="ESTOCCUPE")
	private int estOccupe;
	
	@ManyToOne
	@JoinColumn(name="ID_METIER")
	private Metier metier;
	
	private static final long serialVersionUID = 1L;

	public Poste() {
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

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	public int getEstOccupe() {
		return estOccupe;
	}

	public void setEstOccupe(int estOccupe) {
		this.estOccupe = estOccupe;
	}
}
