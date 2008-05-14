package entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NiveauFormPK implements Serializable {
	@Column(name="ID_COMPETENCE")
	private Integer idCompetence;

	@Column(name="ID_FORMATION")
	private Integer idFormation;

	private static final long serialVersionUID = 1L;

	public NiveauFormPK() {
		super();
	}

	public Integer getIdCompetence() {
		return idCompetence;
	}

	public void setIdCompetence(Integer idCompetence) {
		this.idCompetence = idCompetence;
	}

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
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
		return this.idCompetence.equals(other.idCompetence)
			&& this.idFormation.equals(other.idFormation);
	}

	@Override
	public int hashCode() {
		return this.idCompetence.hashCode()
			^ this.idFormation.hashCode();
	}
}
