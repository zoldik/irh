package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.Inscription;


public class ListeInscriptionsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Inscription inscription = (Inscription)this.getCurrentRowObject();
        
        return "<a href=\"modif_inscription.htm?" + inscription.getPk() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'inscription\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Inscription inscription = (Inscription)this.getCurrentRowObject();
        
        return "<a href=\"suppr_inscription.htm?" + inscription.getPk() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette inscription ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer cette inscription\"/>" +
        			"</a>";
    }
	
	public String getNomEmploye()
	{
		return "TODO";
	}
	
	public String getPrenomEmploye()
	{
		return "TODO";
	}
}
