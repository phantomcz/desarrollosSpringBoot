package com.latam.springapp.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.latam.springapp.service.ManejadorPersonaService;
import com.latam.springapp.utiles.UtilFechas;
import com.latam.springapp.web.domain.Persona;
import com.latam.springapp.web.domain.Poema;


public class ManejadorPersonaImpl implements ManejadorPersonaService {

	private static final long serialVersionUID = 5800636459651057188L;
	
	protected final Log logger = LogFactory.getLog(ManejadorPersonaImpl.class);
	
	@Override
	public Persona obtenerMensaje(Persona persona) {
			
		if (null != persona && null != persona.getFechaNac()) {
			Date fechaNac = persona.getFechaNac();
			Date fechaActual = new Date();
			
			int edad = UtilFechas.obtenerAnio(fechaActual) - UtilFechas.obtenerAnio(fechaNac);
			persona.setEdad(edad);
			
			int diasCumple = UtilFechas.obtenerDiasCumple(fechaNac, fechaActual);
			
			if (diasCumple == 0) {
				//feliz Cumpleaños!!! agregar poema
				persona.setPoemaCumple(obtenerPoema());
			}
			
			persona.setDiasCuple(diasCumple);
			persona.setEdad(edad);
			
			if (null != persona.getNombres()) {
				persona.setNombre(persona.getNombres().split(" ")[0]);
			}
		}
		
		return persona;
	}

	private String obtenerPoema() {
		String url = "https://www.poemist.com/api/v1/randompoems";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Poema>> rateResponse =
		        restTemplate.exchange(url,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Poema>>() {
		            });
		List<Poema> listaPoemas = rateResponse.getBody();
				
		int randomNro = (int) (Math.random()*listaPoemas.size()-1);
		
		Poema poemaRdm = listaPoemas.get(randomNro);
		
		
		return poemaRdm.getContent();
	}
	
	
	
	

}
