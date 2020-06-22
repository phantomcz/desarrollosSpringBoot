package com.latam.springapp.utiles;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilFechas {
	
	final static String fanio = "yyyy";
	static SimpleDateFormat formatoAnio = new SimpleDateFormat(fanio);
	
	
	final static String fmes = "MM";
	static SimpleDateFormat formatoMes = new SimpleDateFormat(fmes);
	
	final static String fdia = "dd";
	static SimpleDateFormat formatoDia = new SimpleDateFormat(fdia);
	
	public static int obtenerAnio(Date fecha) {
		int anio = 0;
		if (null !=fecha ) {
			String anioStr = formatoAnio.format(fecha);
			anio = new Integer(anioStr);
		}
		
		return anio;
	}
	
	public static int obtenerMes(Date fecha) {
		int mes = 0;
		if (null !=fecha ) {
			String mesStr = formatoMes.format(fecha);
			mes = new Integer(mesStr);
		}
		
		return mes;
	}
	
	public static int obtenerDia(Date fecha) {
		int dia = 0;
		if (null !=fecha ) {
			String anioDia = formatoDia.format(fecha);
			dia = new Integer(anioDia);
		}
		
		return dia;
	}
	

	public static int obtenerDiasCumple(Date fechaNac, Date fechaActual) {
		
		int diasCumple = 0;
		
		if (null != fechaNac && null != fechaActual) {
			
			int diasAnioNac = obtenerDiasAnioActual(fechaNac);
			int diasAnioActual = obtenerDiasAnioActual(fechaActual);
					
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNac);
			calendar.set(Calendar.YEAR, obtenerAnio(fechaActual)+1);
			Date fechaNacProx = calendar.getTime();
			
			int diasAnioNacProx = obtenerDiasAnioActual(fechaNacProx);
						
			Calendar calendarFin = Calendar.getInstance();
			calendarFin.setTime(fechaActual);
			calendarFin.set(Calendar.MONTH, Calendar.DECEMBER);
			calendarFin.set(Calendar.DAY_OF_MONTH, 31);
			Date fechafinAnio = calendarFin.getTime();
			
			int diasFinAnio = obtenerDiasAnioActual(fechafinAnio);
			
			if (diasAnioActual < diasAnioNac) {
				diasCumple = diasAnioNac - diasAnioActual;
			} else if (diasAnioActual > diasAnioNac) {
				diasCumple = diasFinAnio - diasAnioActual + diasAnioNacProx;
			}
		}
		
		return diasCumple;
	}
	
	public static int obtenerDiasAnioActual(Date fecha) {
		
		int diasAnioActual = 1;
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		diasAnioActual = calendar.get(Calendar.DAY_OF_YEAR);		
		
		return diasAnioActual;
	}
	
}
