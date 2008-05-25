package web.formations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entities.Inscription;
import entities.InscriptionPK;

import services.IServiceInscription;

public class SupprInscriptionController implements Controller {

	private IServiceInscription si;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception
	{	
		// Recupere l'idEmploye
		int idEmploye = -1;
		try { idEmploye = Integer.parseInt(arg0.getParameter("id_employe")); }
		catch (Exception e) { e.printStackTrace(); }
		
		// Recupere l'idSessionFormation
		int idSessionFormation = -1;
		try { idSessionFormation = Integer.parseInt(arg0.getParameter("id_session_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		
		// Creation de la cle primaire
		InscriptionPK pk = new InscriptionPK();
		pk.setIdEmploye(idEmploye);
		pk.setIdSessionFormation(idSessionFormation);
				
		// Supprime
		Inscription inscription = new Inscription();
		inscription.setPk(pk);
		si.deleteInscription(inscription);
		
		// Redirige vers la liste des session de formation
		/* TO FIX : il y a peut etre plus propre a faire avec Spring, mais bon
		 * ca marche !
		 */
		
		//Recupere l'id du plan de formation pour la redirection
		int idPlanFormation = -1;
		try { idPlanFormation = Integer.parseInt(arg0.getParameter("id_plan_formation")); }
		catch (Exception e) { e.printStackTrace(); }
		arg1.sendRedirect("liste_inscriptions.htm?id_session_formation=" + idSessionFormation + "&id_plan_formation=" + idPlanFormation);
		
		return null;
	}

	public IServiceInscription getSi() {
		return si;
	}

	public void setSi(IServiceInscription si) {
		this.si = si;
	}
}
