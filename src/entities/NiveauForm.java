package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NIVEAU_FORM")
public class NiveauForm implements Serializable {
	@EmbeddedId
	private NiveauFormPK pk;

	@Column(name="NIVEAU")
	private int niveau;

	private static final long serialVersionUID = 1L;

	public NiveauForm() {
		super();
	}

	public NiveauFormPK getPk() {
		return this.pk;
	}

	public void setPk(NiveauFormPK pk) {
		this.pk = pk;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
