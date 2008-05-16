package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.PlanFormation;


public class ListePlanFormationsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        PlanFormation plan= (PlanFormation)this.getCurrentRowObject();
        
        return "<a href=\"modif_plan_formation.htm?id=" + plan.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier le plan de formation\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		PlanFormation plan= (PlanFormation)this.getCurrentRowObject();
        
        return "<a href=\"suppr_plan_formation.htm?id=" + plan.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer ce plan de formation ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer le plan de formation\"/>" +
        			"</a>";
    }
}
