package web.carrieres;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import entities.Evaluation;


public class ListeEvaluationsDecorator extends TableDecorator {
	
	public String getEditLink()
    {
		Evaluation evaluation= (Evaluation)this.getCurrentRowObject();
        
        return "<a href=\"modif_evaluation.htm?id=" + evaluation.getId() + "\">" +
        			"<img src=\"./images/edit.png\" alt=\"Modifier l'&eacute;valuation\"/>" +
        			"</a>";
    }
	
	public String getSupprLink()
    {
		Evaluation evaluation= (Evaluation)this.getCurrentRowObject();
        
        return "<a href=\"suppr_evaluation.htm?id=" + evaluation.getId() + "\" onclick=\"javascript: return confirm('Voulez-vous supprimer cette &eacute;valuation ?');\">" +
        			"<img src=\"./images/delete.png\" alt=\"Supprimer l'&eacute;valuation\"/>" +
        			"</a>";
    }
	
	public String getDateEvaluationShortFormat()
	{
		Evaluation evaluation= (Evaluation)this.getCurrentRowObject();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(evaluation.getDateEvaluation());
	}
}
