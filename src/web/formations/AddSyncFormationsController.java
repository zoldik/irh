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
import entities.NiveauForm;
import entities.NiveauFormPK;
import entities.Organisme;
import entities.Competence;

import services.IServiceCompetence;
import services.IServiceFormation;
import services.IServiceNiveauForm;
import services.IServiceOrganisme;



public class AddSyncFormationsController extends SimpleFormController {
	
	private IServiceFormation sf;
	private IServiceOrganisme so;
	private IServiceCompetence sc;
	private IServiceNiveauForm snf;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractFormController#formBackingObject(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return super.formBackingObject(request);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
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
        	// TODO : Faisable : Verifier la validité du fichier
        	// TODO : Difficile : Supprimer les formations et competences de l'organisme qui sont non utilisees par le systeme.
        	
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
            	
            	// On recupere l'id de l'organisme ajoute
                for (Organisme organisme : so.listOrganismes()) {
    				if(organisme.getNom().equals(nomOrganisme))
    				{
    					idOrganisme = organisme.getId();
    				}
    			}
            }            
            // Sinon, on le modifie
            else
            {
            	Organisme orga = so.getOrganisme(idOrganisme);
            	orga.setDescription(descriptionOrganisme);
            	
            	so.updateOrganisme(orga);
            }
            
        	// On recupere la collection de formation
            List<Node> nodes = document.selectNodes( "//organisme/formations/formation" );
    
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
					if((formation.getLibelle().equals(libelleFormation)) && (formation.getOrganisme().getId() == idOrganisme))
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
            		
            		// Recuperation de l'id de la formation ajoutee
            		for (Formation formation : sf.listFormations())
            		{
            			if(formation.getLibelle().equals(libelleFormation))
    					{
    						idFormation = formation.getId();
    					}
            		}
            	}
        		// Sinon, on la modifie
            	else
            	{
            		Formation f = sf.getFormation(idFormation);
            		f.setDuree(dureeFormation);
            		//f.setOrganisme(so.getOrganisme(idOrganisme));
            		f.setPrixParPersonne(prixParPersonneFormation);
            		
            		sf.updateFormation(f);
            	}
            	
            	// On recupere la collection des competences
                List<Node> nodesCompetence = n.selectNodes( "./competences/competence" );
                // Pour chaque noeud xml de competences,
                for (Node nc : nodesCompetence)
                {
                	String libelleCompetence = nc.selectSingleNode("./libelle").getText();
                	int niveauCompetence = Integer.parseInt(nc.selectSingleNode("./niveau").getText());
                	
                	// Verification la presence de la competence
                	boolean competencePresente = false;
                	int idCompetence = -1;
                	List<Competence> competences = sc.listCompetences();
                	for (Competence competence : competences) {
    					if(competence.getLibelle().equals(libelleCompetence))
    					{
    						competencePresente = true;
    						idCompetence = competence.getId();
    					}
    				}
                	// Si, elle n'est pas presente, on l'ajoute.
                	if(!competencePresente)
                	{
                		// Ajout de la competence dans la Table COMPETENCE.
                		Competence c = new Competence();
                		c.setLibelle(libelleCompetence);
                		sc.addCompetence(c);                		
                		
                		// Recuperation de l'id de la competence ajoute
                		for (Competence competence : sc.listCompetences())
                		{
                			if(competence.getLibelle().equals(libelleCompetence))
        					{
        						idCompetence = competence.getId();
        					}
                		}
                		
                		// Preparation de la cle primaire composee
                		NiveauFormPK nfPK = new NiveauFormPK();                		
                		nfPK.setIdCompetence(idCompetence);
                		nfPK.setIdFormation(idFormation);
                		// Ajout du niveau dans la Table NIVEAU_FORM.
                		NiveauForm nf = new NiveauForm();
                		nf.setPk(nfPK);
                		nf.setNiveau(niveauCompetence);
                		snf.addNiveauForm(nf);
                	}
            		// Sinon, on la modifie
                	else
                	{
                		// Preparation de la cle primaire composee
                		NiveauFormPK nfPK = new NiveauFormPK();                		
                		nfPK.setIdCompetence(idCompetence);
                		nfPK.setIdFormation(idFormation);
                	
                		// Verification de la presence du niveau asssocie a la competence
                		// dans la table NIVEAU_FORM
                		boolean niveauFormPresent = false;
                    	
                    	for (NiveauForm niveauForm : snf.listNiveauForms()) {
        					if(niveauForm.getPk().equals(nfPK))
        					{
        						System.out.println("DEBUG : Coucou");
        						niveauFormPresent = true;
        					}
        				}
                    	// Si, il n'est pas presente, on l'ajoute.
                    	if(!niveauFormPresent)
                    	{
                    		NiveauForm nf = new NiveauForm();
                    		nf.setPk(nfPK);
                    		nf.setNiveau(niveauCompetence);
                    		snf.addNiveauForm(nf);
                    		
                    		System.out.println("DEBUG : NiveauForm ajoute");
                    	}
                    	// Sinon, on modifie.
                    	else
                    	{
                    		// Modification du niveau dans la Table NIVEAU_FORM.
                    		NiveauForm nf = new NiveauForm();
                    		nf.setPk(nfPK);
                    		nf.setNiveau(niveauCompetence);
                    		snf.updateNiveauForm(nf);
                    		
                    		System.out.println("DEBUG : NiveauForm modifie");
                    	}
                	}
                }
			}
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

	public IServiceCompetence getSc() {
		return sc;
	}

	public void setSc(IServiceCompetence sc) {
		this.sc = sc;
	}

	public IServiceNiveauForm getSnf() {
		return snf;
	}

	public void setSnf(IServiceNiveauForm snf) {
		this.snf = snf;
	}
}
