package entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InscriptionPK implements Serializable {
	@Column(name="ID_EMPLOYE")
	private int idEmploye;

	@Column(name="ID_SESSION")
	private int idSessionFormation;

	private static final long serialVersionUID = 1L;

	public InscriptionPK() {
		super();
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public int getIdSessionFormation() {
		return idSessionFormation;
	}

	public void setIdSessionFormation(int idSessionFormation) {
		this.idSessionFormation = idSessionFormation;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof InscriptionPK)) {
			return false;
		}
		InscriptionPK other = (InscriptionPK) o;
		return (this.idEmploye == other.idEmploye)
			&& (this.idSessionFormation == other.idSessionFormation);
	}

	@Override
	public int hashCode() {
		return (((Integer)this.idEmploye).hashCode()
			^ ((Integer)this.idSessionFormation).hashCode());
	}
}
