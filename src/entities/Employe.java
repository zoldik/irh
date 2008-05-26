package entities;
import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYE")
public class Employe implements Serializable {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ_EMPLOYE")
	@SequenceGenerator(name="SEQ_EMPLOYE", sequenceName = "SEQ_EMPLOYE")
	private int id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;

	@Column(name="TELEPHONE_PRO")
	private String telephonePro;
	
	@Column(name="TELEPHONE_MOBILE")
	private String telephoneMobile;
	
	@Column(name="TELEPHONE_PERSO")
	private String telephonePerso;
	
	@Column(name="FAX")
	private String fax;

	@Column(name="DATE_NAISSANCE")
	private Date dateNaissance;

	@Column(name="EMAIL")
	private String email;

	@Column(name="ADR_RUE")
	private String adrRue;

	@Column(name="ADR_CP")
	private String adrCp;

	@Column(name="ADR_VILLE")
	private String adrVille;
	
	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NB_ENFANTS")
	private BigDecimal nbEnfants;

	@ManyToOne
	@JoinColumn(name="ID_CIVILITE")
	private Civilite civilite;
	
	@ManyToOne
	@JoinColumn(name="ID_SITUATION_FAMILIALE")
	private SituationFamiliale situationFamiliale;
	
	@OneToMany(mappedBy="employe")
	private Set<Diplome> diplomeCollection;
	
	@OneToMany(mappedBy="employe")
	private Set<EmploiPrecedent> emploiPrecedentCollection;
	
	@OneToMany(mappedBy="employe")
	private Set<Evaluation> evaluationCollection;
	
	// TODO : Implementer poste
	//@Column(name="ID_POSTE")
	//private BigDecimal idPoste;

	private static final long serialVersionUID = 1L;

	public Employe() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephonePro() {
		return telephonePro;
	}

	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getTelephonePerso() {
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) {
		this.telephonePerso = telephonePerso;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdrRue() {
		return adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	public String getAdrCp() {
		return adrCp;
	}

	public void setAdrCp(String adrCp) {
		this.adrCp = adrCp;
	}

	public String getAdrVille() {
		return adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(BigDecimal nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public SituationFamiliale getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public Set<Diplome> getDiplomeCollection() {
		return diplomeCollection;
	}

	public void setDiplomeCollection(Set<Diplome> diplomeCollection) {
		this.diplomeCollection = diplomeCollection;
	}

	public Set<EmploiPrecedent> getEmploiPrecedentCollection() {
		return emploiPrecedentCollection;
	}

	public void setEmploiPrecedentCollection(
			Set<EmploiPrecedent> emploiPrecedentCollection) {
		this.emploiPrecedentCollection = emploiPrecedentCollection;
	}

	@Override
	public String toString() {
		return this.nom + " " + this.prenom;
	}

	public Set<Evaluation> getEvaluationCollection() {
		return evaluationCollection;
	}

	public void setEvaluationCollection(Set<Evaluation> evaluationCollection) {
		this.evaluationCollection = evaluationCollection;
	}

}
