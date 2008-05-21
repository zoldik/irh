package web.carrieres;

import org.displaytag.decorator.TableDecorator;

import entities.Metier;


public class ListeMetiersDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Metier metier = (Metier)this.getCurrentRowObject();
        
        return "<a href=\"modif_metier.htm?id=" + metier.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier le m&eacute;tier\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Metier metier = (Metier)this.getCurrentRowObject();
        
        return "<a href=\"suppr_metier.htm?id=" + metier.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer ce m&eacute;tier?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer le m&eacute;tier\"/>" +
        			"</a>";
    }
}
