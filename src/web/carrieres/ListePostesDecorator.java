package web.carrieres;

import org.displaytag.decorator.TableDecorator;

import entities.Poste;


public class ListePostesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Poste poste = (Poste)this.getCurrentRowObject();
        
        return "<a href=\"modif_poste.htm?id=" + poste.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier le poste\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Poste poste = (Poste)this.getCurrentRowObject();
        
        return "<a href=\"suppr_poste.htm?id=" + poste.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer ce poste ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer le poste\"/>" +
        			"</a>";
    }
}
