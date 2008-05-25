package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.Inscription;


public class ListeInscriptionsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Inscription inscription = (Inscription)this.getCurrentRowObject();
        
        return "<a href=\"modif_inscription.htm?" + inscription.getPk() + "&id_plan_formation=" + inscription.getSessionFormation().getPlanFormation().getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'inscription\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Inscription inscription = (Inscription)this.getCurrentRowObject();
        
        return "<a href=\"suppr_inscription.htm?" + inscription.getPk() + "&id_plan_formation=" + inscription.getSessionFormation().getPlanFormation().getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette inscription ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer cette inscription\"/>" +
        			"</a>";
    }
	
	public String getNomEmploye()
	{
		Inscription inscription = (Inscription)this.getCurrentRowObject();
		
		return inscription.getEmploye().getNom();
	}
	
	public String getPrenomEmploye()
	{
		Inscription inscription = (Inscription)this.getCurrentRowObject();
		
		return inscription.getEmploye().getPrenom();
	}
	
	public String getPresenceHumanReadable()
	{
		Inscription inscription = (Inscription)this.getCurrentRowObject();
		
		String text = "";
		if(inscription.getPresence()) text = "Oui";
		else text = "Non";
		
        return text;
	}
}
