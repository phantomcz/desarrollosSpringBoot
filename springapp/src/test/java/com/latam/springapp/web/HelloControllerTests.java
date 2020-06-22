package com.latam.springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.latam.springapp.impl.ManejadorPersonaImpl;


public class HelloControllerTests {

	 @Test
	 public void testHandleRequestView() throws Exception{		
		 HelloController controller = new HelloController();
		 controller.setManejadorPersonaService(new ManejadorPersonaImpl());
		 ModelAndView modelAndView = controller.handleRequest(null, null);		
		 assertEquals("hello", modelAndView.getViewName());
		 assertNotNull(modelAndView.getModel());
		 @SuppressWarnings("unchecked")
		 Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
//		 String nowValue = (String) modelMap.get("now");
//		 String nowValue = (String) modelAndView.getModel().get("now");
//		 assertNotNull(nowValue);
		 
	 }
}
