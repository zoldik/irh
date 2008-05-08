package web.administration;

import org.displaytag.decorator.TableDecorator;

import entities.Employe;


public class ListeEmployesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        Employe employe = (Employe)this.getCurrentRowObject();
        
        return "<a href=\"modif_employe.htm?id=" + employe.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'employé\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Employe employe = (Employe)this.getCurrentRowObject();
        
        return "<a href=\"suppr_employe.htm?id=" + employe.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cet employé?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer l'employé\"/>" +
        			"</a>";
    }
}
