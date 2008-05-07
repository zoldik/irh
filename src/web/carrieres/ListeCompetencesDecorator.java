package web.carrieres;

import org.displaytag.decorator.TableDecorator;

import entities.Competence;


public class ListeCompetencesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Competence comp = (Competence)this.getCurrentRowObject();
        
        return "<a href=\"modif_competence.htm?id=" + comp.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier la comp&eacute;tence\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Competence comp = (Competence)this.getCurrentRowObject();
        
        return "<a href=\"suppr_competence.htm?id=" + comp.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette comp&eacute;tence ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer la comp&eacute;tence\"/>" +
        			"</a>";
    }
}
