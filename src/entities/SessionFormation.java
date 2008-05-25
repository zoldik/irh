package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="SESSIONS")
public class SessionFormation implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_SESSIONS")
	@SequenceGenerator(name="SEQ_SESSIONS", sequenceName = "SEQ_SESSIONS")
	private int id;

	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="ID_FORMATION")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="ID_PLAN_FORMATION")
	private PlanFormation planFormation;
	
	private static final long serialVersionUID = 1L;

	public SessionFormation() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public PlanFormation getPlanFormation() {
		return planFormation;
	}

	public void setPlanFormation(PlanFormation planFormation) {
		this.planFormation = planFormation;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return this.formation + " du " + dateFormat.format(this.dateDebut) + " au " + dateFormat.format(this.dateFin);
	}
}
