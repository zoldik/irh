package web.formations;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.multipart.support.StringMultipartFileEditor;

import entities.TextFileUploadBean;

import entities.Formation;
import entities.Organisme;

import services.IServiceFormation;
import services.IServiceOrganisme;



public class AddSyncFormationsController extends SimpleFormController {
	
	private IServiceFormation sf;
	private IServiceOrganisme so;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return super.formBackingObject(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		return super.referenceData(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.BaseCommandController#initBinder(javax.servlet.http.HttpServletRequest, org.springframework.web.bind.ServletRequestDataBinder)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		// Convertion du Multipart en String
        binder.registerCustomEditor(String.class, new StringMultipartFileEditor());
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		TextFileUploadBean file = (TextFileUploadBean)command;
		
		String fichierXml = file.getFile();
		
        if (fichierXml == null) {
        	System.out.println("DEBUG : NULL");
        }
        else
        {
        	// TODO : Verifier la validité du fichier
        	
        	// Chargement du fichierXml dans le parseur xml
            Document document = DocumentHelper.parseText(fichierXml);
            
            // Recuperation du nom de l'organisme
            Node node = document.selectSingleNode( "//organisme/nom" );
            String nomOrganisme = node.getText();
            
            // Recuperation de la description de l'organisme
            node = document.selectSingleNode( "//organisme/description" );
            String descriptionOrganisme = node.getText();
            
             
            // Verification de la presence de l'organisme
            boolean organismePresent = false;
            int idOrganisme = -1;
            List<Organisme> listeOrganismes = so.listOrganismes();
            for (Organisme organisme : listeOrganismes) {
				if(organisme.getNom().equals(nomOrganisme))
				{
					organismePresent = true;
					idOrganisme = organisme.getId();
				}
			}
            // Si il n'est pas present on l'ajoute.
            if(!organismePresent)
            {
            	Organisme orga = new Organisme();
            	orga.setNom(nomOrganisme);
            	orga.setDescription(descriptionOrganisme);
            	
            	so.addOrganisme(orga);
            }            
            // Sinon, on le modifie
            else
            {
            	Organisme orga = so.getOrganisme(idOrganisme);
            	orga.setDescription(descriptionOrganisme);
            	
            	so.updateOrganisme(orga);
            }
            
        	// On recupere la collection de formation a ajouter ou modifier
            List<Node> nodes = document.selectNodes( "//organisme/formations_a_ajouter_modifier/formation" );
    
        	// Pour chaque noeud xml de formation,
            for (Node n : nodes)
            {
            	// Recuperation des informations de la formation
            	String libelleFormation = n.selectSingleNode("./libelle").getText();
            	double prixParPersonneFormation = Double.parseDouble(n.selectSingleNode("./prix_par_personne").getText());
            	double dureeFormation = Double.parseDouble(n.selectSingleNode("./duree").getText());
            	// Verification la presence de la formation
            	boolean formationPresente = false;
            	int idFormation = -1;
            	List<Formation> formations = sf.listFormations();
            	for (Formation formation : formations) {
					if(formation.getLibelle().equals(libelleFormation))
					{
						formationPresente = true;
						idFormation = formation.getId();
					}
				}
            	// Si, elle n'est pas presente, on l'ajoute.
            	if(!formationPresente)
            	{
            		Formation f = new Formation();
            		f.setLibelle(libelleFormation);
            		f.setDuree(dureeFormation);
            		f.setOrganisme(so.getOrganisme(idOrganisme));
            		f.setPrixParPersonne(prixParPersonneFormation);
            		
            		sf.addFormation(f);
            	}
        		// Sinon, on la modifie
            	else
            	{
            		Formation f = sf.getFormation(idFormation);
            		f.setDuree(dureeFormation);
            		f.setOrganisme(so.getOrganisme(idOrganisme));
            		f.setPrixParPersonne(prixParPersonneFormation);
            		
            		sf.updateFormation(f);
            	}
			}
        		
        		
        
	         // On recupere la collection de formation a supprimer       
	        	// Pour chaque formation
	        		// Verification la presence de la formation
	        		// Si, elle est presente, on la supprime.
		   
           //TODO : gerer les competences associees a chaque formation.
            
            
        }		
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceFormation getSf() {
		return sf;
	}

	public void setSf(IServiceFormation sf) {
		this.sf = sf;
	}

	public IServiceOrganisme getSo() {
		return so;
	}

	public void setSo(IServiceOrganisme so) {
		this.so = so;
	}
}
