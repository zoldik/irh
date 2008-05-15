package entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NiveauFormPK implements Serializable {
	@Column(name="ID_COMPETENCE")
	private int idCompetence;

	@Column(name="ID_FORMATION")
	private int idFormation;

	private static final long serialVersionUID = 1L;

	public NiveauFormPK() {
		super();
	}

	public int getIdCompetence() {
		return idCompetence;
	}

	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof NiveauFormPK)) {
			return false;
		}
		NiveauFormPK other = (NiveauFormPK) o;
		return (this.idCompetence == other.idCompetence)
			&& (this.idFormation == other.idFormation);
	}

	@Override
	public int hashCode() {
		return (((Integer)this.idCompetence).hashCode()
			^ ((Integer)this.idFormation).hashCode());
	}
}
