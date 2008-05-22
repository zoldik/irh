package web.formations;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import entities.SessionFormation;


public class ListeSessionFormationsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        SessionFormation session = (SessionFormation)this.getCurrentRowObject();
        
        return "<a href=\"modif_session_formation.htm?id=" + session.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier la session de formation\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		SessionFormation session = (SessionFormation)this.getCurrentRowObject();
        
        return "<a href=\"suppr_session_formation.htm?id=" + session.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette session de formation ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer la session de formation\"/>" +
        			"</a>";
    }
	
	public String getSubscribeLink()
	{
		SessionFormation session = (SessionFormation)this.getCurrentRowObject();
        
        return "<a href=\"inscription_session_formation.htm?id=" + session.getId() + "\">" +
					"<img src=\"./images/add_user.png\" alt=\"Inscrire quelqu'un la session de formation\"/>" +
					"</a>";
    }
	
	public String getNbParticipants()
	{
		//SessionFormation session = (SessionFormation)this.getCurrentRowObject();
		//TODO : Calculer le nombre de participant a la session
		return "3";
	}
	
	public String getprixTotal()
	{
		//SessionFormation session = (SessionFormation)this.getCurrentRowObject();
		//TODO : Calculer le prix total de la session
		
		return "600";
	}
	
	public String getDateDebutShortFormat()
	{
		SessionFormation session = (SessionFormation)this.getCurrentRowObject();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(session.getDateDebut());
	}
	
	public String getDateFinShortFormat()
	{
		SessionFormation session = (SessionFormation)this.getCurrentRowObject();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(session.getDateFin());
	}
}
