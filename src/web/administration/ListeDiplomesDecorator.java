package web.administration;

import org.displaytag.decorator.TableDecorator;

import entities.Diplome;


public class ListeDiplomesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        Diplome diplome = (Diplome)this.getCurrentRowObject();
        
        return "<a href=\"modif_diplome.htm?id=" + diplome.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier le diplôme\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Diplome diplome = (Diplome)this.getCurrentRowObject();
        
        return "<a href=\"suppr_diplome.htm?id=" + diplome.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer ce diplôme?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer le diplôme\"/>" +
        			"</a>";
    }
}
