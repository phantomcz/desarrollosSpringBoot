package com.latam.springapp.web.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = -2809110625866862081L;
	
	private String nombres;
	private String apellido;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNac;
	
	//respuesta
	private int diasCuple;
	private int edad;
	private String poemaCumple;
	private String nombre;

	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public int getDiasCuple() {
		return diasCuple;
	}
	public void setDiasCuple(int diasCuple) {
		this.diasCuple = diasCuple;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPoemaCumple() {
		return poemaCumple;
	}
	public void setPoemaCumple(String poemaCumple) {
		this.poemaCumple = poemaCumple;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", diasCuple="
				+ diasCuple + ", edad=" + edad + ", poemaCumple=" + poemaCumple + ", nombre=" + nombre + "]";
	}
	
	
}

