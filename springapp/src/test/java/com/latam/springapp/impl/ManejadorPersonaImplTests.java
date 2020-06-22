package com.latam.springapp.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.latam.springapp.service.ManejadorPersonaService;
import com.latam.springapp.web.domain.Persona;

public class ManejadorPersonaImplTests {
		
	private ManejadorPersonaService manejadorPersonaSvc;
	Persona personaPrev = null;
	Persona personaPost = null;
	Persona personaCumple = null;
	private String formatoFecha = "dd/MM/yyyy";
	SimpleDateFormat fFecha = new SimpleDateFormat(formatoFecha);
	
	@Before
	public void setUp() throws Exception {
		manejadorPersonaSvc = new ManejadorPersonaImpl();
		personaPrev = new Persona();
		
		personaPrev.setNombres("Andres Eduardo");
		personaPrev.setApellido("Miranda");
		personaPrev.setFechaNac(fFecha.parse("15/08/1984"));
		
		personaPost = new Persona();
		
		personaPost.setNombres("Andres Eduardo");
		personaPost.setApellido("Miranda");
		personaPost.setFechaNac(fFecha.parse("17/01/1984"));
		
		personaCumple = new Persona();
		
		personaCumple.setNombres("Andres Eduardo");
		personaCumple.setApellido("Miranda");
		personaCumple.setFechaNac(new Date());
		
		
	}
	
	@Test
    public void testObtenerMensajeProxAnio() {
		manejadorPersonaSvc = new ManejadorPersonaImpl();

		assertNotEquals(0, manejadorPersonaSvc.obtenerMensaje(personaPost).getDiasCuple());
    }
	
	@Test
    public void testObtenerMensajeDiasCumple() {
		manejadorPersonaSvc = new ManejadorPersonaImpl();

		assertNotEquals(0, manejadorPersonaSvc.obtenerMensaje(personaPrev).getDiasCuple());
    }
	
	@Test
    public void testObtenerMensajeFelizCumple() {
		manejadorPersonaSvc = new ManejadorPersonaImpl();

		assertNotNull("exito", manejadorPersonaSvc.obtenerMensaje(personaCumple).getPoemaCumple());
    }

}
