package com.latam.springapp.web;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latam.springapp.service.ManejadorPersonaService;
import com.latam.springapp.web.domain.Persona;

@Controller
@RequestMapping(value="/saludo")
public class SaludoCumpleController {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    
    @Autowired
    private ManejadorPersonaService manejadorPersonaService;
	
	
    @RequestMapping(value = "/saludoCumple", method = RequestMethod.POST)
    public String onSubmit(Persona persona, BindingResult result)
    {
    	if (result.hasErrors()) {
    		return "saludoCumple";
    	}
    	
    	Persona personaSaludada = manejadorPersonaService.obtenerMensaje(persona);
        logger.info("Persona a saludar " + personaSaludada);
        return "redirect:/hello.htm";
    }


	public ManejadorPersonaService getManejadorPersonaService() {
		return manejadorPersonaService;
	}


	public void setManejadorPersonaService(ManejadorPersonaService manejadorPersonaService) {
		this.manejadorPersonaService = manejadorPersonaService;
	}
    
	@ModelAttribute("personaIngreso")
	public Persona populateForm() {
	     return new Persona();
	}
    
}
