package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String aMessage = "Hello World MVC!";
		 
		ModelAndView myModelAndView = new ModelAndView("helloworld");
		myModelAndView.addObject("message", aMessage);
 
		return myModelAndView;
	}

}
