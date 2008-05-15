package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Diplome implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_DIPLOME")
	@SequenceGenerator(name="SEQ_DIPLOME", sequenceName = "SEQ_DIPLOME")
	private int id;

	@ManyToOne
	@JoinColumn(name="ID_EMPLOYE")
	private Employe employe;

	@ManyToOne
	@JoinColumn(name="ID_NIVEAU")
	private NiveauEtude niveau;

	@Column(name="DENOMINATION")
	private String denomination;

	@Column(name="ETABLISSEMENT")
	private String etablissement;
	
	@Column(name="ANNEE")
	private int annee;

	private static final long serialVersionUID = 1L;

	public Diplome() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public NiveauEtude getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauEtude niveau) {
		this.niveau = niveau;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	
}
