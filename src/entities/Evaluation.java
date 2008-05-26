package entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;

@Entity
@Table(name="EVALUATION")
public class Evaluation implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_EVALUATION")
	@SequenceGenerator(name="SEQ_EVALUATION", sequenceName = "SEQ_EVALUATION")
	private int id;

	@Column(name="DATE_EVAL")
	private Date dateEvaluation;
	
	@Column(name="COMMENTAIRE")
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPLOYE")
	private Employe employe;
	
	@Transient
	private Competence competence;
	
	@Transient
	private int niveauCompetence;
	
	private static final long serialVersionUID = 1L;

	public Evaluation() {
		super();
	}

	public int getId() {
		return this.id;
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

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public int getNiveauCompetence() {
		return niveauCompetence;
	}

	public void setNiveauCompetence(int niveauCompetence) {
		this.niveauCompetence = niveauCompetence;
	}
}
