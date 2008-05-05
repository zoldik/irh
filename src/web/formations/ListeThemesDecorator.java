package web.formations;

import org.displaytag.decorator.TableDecorator;

import entities.Theme;


public class ListeThemesDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        Theme theme= (Theme)this.getCurrentRowObject();
        
        return "<a href=\"modif_theme.htm?id=" + theme.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier le th&egrave;me\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Theme theme= (Theme)this.getCurrentRowObject();
        
        return "<a href=\"suppr_theme.htm?id=" + theme.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer ce th&egrave;me ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer le th&egrave;me\"/>" +
        			"</a>";
    }
}
