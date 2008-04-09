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
@Table(name="UTILISATEUR") 
public class Utilisateur implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_UTILISATEUR")
	@SequenceGenerator(name="SEQ_UTILISATEUR", sequenceName = "SEQ_UTILISATEUR")
	private int id;

	@Column(name="NOM")
	private String nom;

	@Column(name="LOGIN")
	private String login;

	@Column(name="PASS")
	private String pass;

	@ManyToOne
	@JoinColumn(name="ID_DROIT")
	private Droit droit;

	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Droit getDroit() {
		return this.droit;
	}

	public void setDroit(Droit idDroit) {
		this.droit = idDroit;
	}

}
