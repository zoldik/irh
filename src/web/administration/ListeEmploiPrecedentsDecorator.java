package web.administration;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import entities.EmploiPrecedent;


public class ListeEmploiPrecedentsDecorator extends TableDecorator {
	
	public String getDateDebutShortFormat()
	{
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(emploiPrecedent.getDateDebut());
	}
	
	public String getDateFinShortFormat()
	{
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(emploiPrecedent.getDateFin());
	}
	
	public String getEditLink()
    {
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
        
        return "<a href=\"modif_emploi_precedent.htm?id=" + emploiPrecedent.getId() + "&employe=" + emploiPrecedent.getEmploye().getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'emploi\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		EmploiPrecedent emploiPrecedent = (EmploiPrecedent)this.getCurrentRowObject();
        
        return "<a href=\"suppr_emploi_precedent.htm?id=" + emploiPrecedent.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cet emploi?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer l'emploi\"/>" +
        			"</a>";
    }
}
