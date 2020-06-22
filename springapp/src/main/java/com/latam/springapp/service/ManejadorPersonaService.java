package com.latam.springapp.service;

import java.io.Serializable;

import com.latam.springapp.web.domain.Persona;

public interface ManejadorPersonaService extends Serializable {
	
	public Persona obtenerMensaje (Persona persona);
	
}
