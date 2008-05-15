package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.IDaoDiplome;
import entities.Diplome;
import entities.Employe;

@Transactional
public class ServiceDiplome implements IServiceDiplome {
	// Couche [dao]
	private IDaoDiplome daoDiplome;
	
	public IDaoDiplome getDaoDiplome() {
		return daoDiplome;
	}

	public void setDaoDiplome(IDaoDiplome daoDiplome) {
		this.daoDiplome = daoDiplome;
	}

	@Override
	public void addDiplome(Diplome diplome) {
		this.daoDiplome.addOne(diplome);		
	}

	@Override
	public void deleteDiplome(Diplome diplome) {
		this.daoDiplome.deleteOne(diplome);		
	}

	@Override
	public Diplome getDiplome(int id) {
		return this.daoDiplome.getOne(id);
	}
	
	@Override
	public void updateDiplome(Diplome diplome) {
		this.daoDiplome.updateOne(diplome);
	}

	@Override
	public List<Diplome> listDiplomes() {
		return this.daoDiplome.listAll();
	}
	
	@Override
	public List<Diplome> listDiplomesEmploye(Employe employe) {
		return this.daoDiplome.listAllEmploye(employe);
	}	
}
