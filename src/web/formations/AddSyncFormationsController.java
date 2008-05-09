package web.formations;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.multipart.support.StringMultipartFileEditor;

import entities.TextFileUploadBean;
import entities.Formation;

import services.IServiceFormation;



public class AddSyncFormationsController extends SimpleFormController {
	
	private IServiceFormation sf;

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
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		TextFileUploadBean file = (TextFileUploadBean)command;
		
		String fichierXml = file.getFile();
		
        if (fichierXml == null) {
        	System.out.println("DEBUG : NULL");
        }
        else
        {
        	// Gestion du fichier xml
    		System.out.println("DEBUG : FICHIER XML");
    		System.out.println(fichierXml);
        }		
		
		return new ModelAndView(new RedirectView(this.getSuccessView()));
	}

	public IServiceFormation getSf() {
		return sf;
	}

	public void setSf(IServiceFormation sf) {
		this.sf = sf;
	}
}
