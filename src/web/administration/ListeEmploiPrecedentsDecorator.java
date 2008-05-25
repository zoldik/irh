package web.administration;

import org.displaytag.decorator.TableDecorator;

import entities.EmploiPrecedent;


public class ListeEmploiPrecedentsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
        
        return "<a href=\"modif_emploi_precedent.htm?id=" + emploiPrecedent.getEmploye().getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'emploi\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
        
        return "<a href=\"suppr_emploi_precedent.htm?id=" + emploiPrecedent.getEmploye().getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cet emploi?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer l'emploi\"/>" +
        			"</a>";
    }
}
