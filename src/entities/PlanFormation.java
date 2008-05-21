package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="PLAN_FORMATION")
public class PlanFormation implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_PLAN_FORMATION")
	@SequenceGenerator(name="SEQ_PLAN_FORMATION", sequenceName = "SEQ_PLAN_FORMATION")
	private int id;
	
	@Column(name="ANNEE")
	private int annee;
	
	@OneToMany(mappedBy="planFormation")
	private Set<SessionFormation> sessionFormationCollection;
	
	private static final long serialVersionUID = 1L;

	public PlanFormation() {
		super();
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.annee);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<SessionFormation> getSessionFormationCollection() {
		return sessionFormationCollection;
	}

	public void setSessionFormationCollection(
			Set<SessionFormation> sessionFormationCollection) {
		this.sessionFormationCollection = sessionFormationCollection;
	}
}
