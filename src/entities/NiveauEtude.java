package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="NIVEAU_ETUDE")
public class NiveauEtude implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(generator="SEQ_NIVEAU_ETUDE")
	@SequenceGenerator(name="SEQ_NIVEAU_ETUDE", sequenceName = "SEQ_NIVEAU_ETUDE")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;

	private static final long serialVersionUID = 1L;

	public NiveauEtude() {
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
}
