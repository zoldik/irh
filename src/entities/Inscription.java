package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="INSCRIPTION")
public class Inscription implements Serializable {
	@EmbeddedId
	private InscriptionPK pk;

	@Column(name="ETAT")
	private String etat;
	
	@Column(name="PRESENCE")
	private boolean presence;

	private static final long serialVersionUID = 1L;

	public Inscription() {
		super();
	}

	public InscriptionPK getPk() {
		return pk;
	}

	public void setPk(InscriptionPK pk) {
		this.pk = pk;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean getPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}
}
