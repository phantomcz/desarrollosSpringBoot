package com.latam.springapp.web.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class PersonaTests {
	
	Persona persona = null;
	
	@Before
    public void setUp() throws Exception {
		persona = new Persona();
    }

	@Test
    public void testSetAndGetNombres() {
        String testNombres = "Andres Eduardo";
        assertNull(persona.getNombres());
        persona.setNombres(testNombres);
        assertEquals(testNombres, persona.getNombres());
    }

    @Test
    public void testSetAndGetApellidos() {
    	String testApellidos = "Miranda";
    	assertNull(persona.getApellido());
        persona.setApellido(testApellidos);
        assertEquals(testApellidos, persona.getApellido());
    }
	
    @Test
    public void testSetAndGetFechaNac() {
    	Date testFechaNac = new Date();
    	assertNull(persona.getFechaNac());
        persona.setFechaNac(testFechaNac);
        assertEquals(testFechaNac, persona.getFechaNac());
    }
	
}
