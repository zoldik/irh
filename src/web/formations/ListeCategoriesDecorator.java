package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.Categorie;;


public class ListeCategoriesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Categorie cat= (Categorie)this.getCurrentRowObject();
        
        return "<a href=\"modif_categorie.htm?id=" + cat.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier la cat&eacute;gorie\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Categorie cat= (Categorie)this.getCurrentRowObject();
        
        return "<a href=\"suppr_categorie.htm?id=" + cat.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette cat&eacute;gorie?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer la cat&eacute;gorie\"/>" +
        			"</a>";
    }
}
