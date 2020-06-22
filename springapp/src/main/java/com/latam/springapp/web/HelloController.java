package com.latam.springapp.web;



import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.latam.springapp.service.ManejadorPersonaService;
import com.latam.springapp.web.domain.Persona;

@Controller
public class HelloController {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ManejadorPersonaService manejadorPersonaService;
	
    @RequestMapping(value="/hello.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	String now = (new Date()).toString();
    	logger.info("Returning hello view with " + now);
    	
        Map<String, Object> myModel = new HashMap<String, Object>();
//        myModel.put("now", now);
        		
		myModel.put("personaIngreso", new Persona());
		
        return new ModelAndView("hello", "model", myModel);
    }
    
    @RequestMapping(value = "/saludoCumple", method = RequestMethod.POST)
    public ModelAndView submit(Persona persona, BindingResult result)
    {
//    	if (result.hasErrors()) {
//    		return "saludoCumple";
//    	}
    	Map<String, Object> myModel = new HashMap<String, Object>();
    	Persona personaSaludada = manejadorPersonaService.obtenerMensaje(persona);
    	
    	persona = new Persona();
        logger.info("Persona a saludar " + personaSaludada);
        
        myModel.put("personaSaludada", personaSaludada);
        
        
//        return "redirect:/saludoCumple.htm";
        return new ModelAndView("hello", "model", myModel);
    }
      
    @ModelAttribute("personaIngreso")
	public Persona populateForm() {
	     return new Persona();
	}
    
    public void setManejadorPersonaService(ManejadorPersonaService manejadorPersonaService) {
        this.manejadorPersonaService = manejadorPersonaService;
    }
}