package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.Formation;


public class ListeFormationsDecorator extends TableDecorator {
	
	public String getDetailsLink()
    {
        Formation formation= (Formation)this.getCurrentRowObject();
        
        return "<a href=\"details_formation.htm?id=" + formation.getId() + "\">" +
        			"<img src=\"./images/details.png\" alt=\"D&eacute;tails sur la formation\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Formation formation= (Formation)this.getCurrentRowObject();
        
        return "<a href=\"suppr_formation.htm?id=" + formation.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette formation ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer la formation\"/>" +
        			"</a>";
    }
}
