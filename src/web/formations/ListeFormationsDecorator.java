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
}
