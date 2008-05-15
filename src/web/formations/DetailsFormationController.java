package web.formations;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Formation;
import entities.NiveauForm;
import entities.Competence;
import entities.Organisme;

import services.IServiceCompetence;
import services.IServiceFormation;
import services.IServiceNiveauForm;
import services.IServiceOrganisme;

public class DetailsFormationController implements Controller {

	private IServiceFormation sf;
	private IServiceOrganisme so;
	private IServiceCompetence sc;
	private IServiceNiveauForm snf;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception
	{
		// Recupere le detail de la formation
		int id = Integer.parseInt(request.getParameter("id"));
		Formation formation = sf.getFormation(id);
		// Recupere les informations sur les competences
		List<Competence> competences = new ArrayList<Competence>();
		List<Integer> niveaux = new ArrayList<Integer>();
		for (NiveauForm niveauForm : snf.listNiveauForms())
		{
			if(niveauForm.getPk().getIdFormation() == formation.getId())
			{
				// Recupere l'id de competence
				competences.add(sc.getCompetence(niveauForm.getPk().getIdCompetence()));
				// Recupere le niveau de la competence
				niveaux.add(niveauForm.getNiveau());
			}
		}
		// Recupere les informations sur l'organisme
		Organisme orga = formation.getOrganisme();
		
		// Ajoute les infos au Model
		ModelAndView myModelAndView = new ModelAndView("details_formation");
		myModelAndView.addObject("formation", formation);
		myModelAndView.addObject("competences", competences);
		myModelAndView.addObject("niveaux", niveaux);
		myModelAndView.addObject("organisme", orga);		
 
		return myModelAndView;
	}

	public IServiceFormation getSf() {
		return sf;
	}

	public void setSf(IServiceFormation sf) {
		this.sf = sf;
	}

	public IServiceOrganisme getSo() {
		return so;
	}

	public void setSo(IServiceOrganisme so) {
		this.so = so;
	}

	public IServiceCompetence getSc() {
		return sc;
	}

	public void setSc(IServiceCompetence sc) {
		this.sc = sc;
	}

	public IServiceNiveauForm getSnf() {
		return snf;
	}

	public void setSnf(IServiceNiveauForm snf) {
		this.snf = snf;
	}
}
