package entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.SequenceGenerator;

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
	
	// TODO : Implementer situationFamiliale
	//@Column(name="ID_SITUATION_FAMILIALE")
	//private BigDecimal idSituationFamiliale;
	
	// TODO : Implementer poste
	//@Column(name="ID_POSTE")
	//private BigDecimal idPoste;

	private static final long serialVersionUID = 1L;

	public Employe() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephonePro() {
		return this.telephonePro;
	}

	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Civilite getCivilite() {
		return this.civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/*public BigDecimal getIdSituationFamiliale() {
		return this.idSituationFamiliale;
	}

	public void setIdSituationFamiliale(BigDecimal idSituationFamiliale) {
		this.idSituationFamiliale = idSituationFamiliale;
	}*/

	public String getTelephonePerso() {
		return this.telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) {
		this.telephonePerso = telephonePerso;
	}

	public BigDecimal getNbEnfants() {
		return this.nbEnfants;
	}

	public void setNbEnfants(BigDecimal nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getAdrRue() {
		return this.adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	/*public BigDecimal getIdPoste() {
		return this.idPoste;
	}

	public void setIdPoste(BigDecimal idPoste) {
		this.idPoste = idPoste;
	}*/

	public String getAdrVille() {
		return this.adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getTelephoneMobile() {
		return this.telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getAdrCp() {
		return this.adrCp;
	}

	public void setAdrCp(String adrCp) {
		this.adrCp = adrCp;
	}

}
