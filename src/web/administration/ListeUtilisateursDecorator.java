package web.administration;

import org.displaytag.decorator.TableDecorator;

import entities.Utilisateur;


public class ListeUtilisateursDecorator extends TableDecorator {
	
	public String getEditLink()
    {
        Utilisateur user= (Utilisateur)this.getCurrentRowObject();
        
        return "<a href=\"modif_utilisateur.htm?id=" + user.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'utilisateur\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
        Utilisateur user= (Utilisateur)this.getCurrentRowObject();
        
        return "<a href=\"suppr_utilisateur.htm?id=" + user.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cet utilisateur?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer l'utilisateur\"/>" +
        			"</a>";
    }
}
