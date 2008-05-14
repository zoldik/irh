package entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SITUATION_FAMILIALE")
public class SituationFamiliale implements Serializable {
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="LIBELLE")
	private String libelle;
	
	@OneToMany(mappedBy="situationFamiliale")
	private Set<Employe> employeCollection;

	private static final long serialVersionUID = 1L;

	public SituationFamiliale() {
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
	
	public Set<Employe> getEmployeCollection() {
		return this.employeCollection;
	}

	public void setEmployeCollection(Set<Employe> employeCollection) {
		this.employeCollection = employeCollection;
	}

	@Override
	public String toString() {
		return this.libelle;
	}

}
