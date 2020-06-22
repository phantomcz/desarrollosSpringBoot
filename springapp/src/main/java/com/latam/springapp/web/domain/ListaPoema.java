package com.latam.springapp.web.domain;

import java.util.ArrayList;
import java.util.List;

public class ListaPoema {
	private List<Poema> poemas;
	
	public ListaPoema() {
		poemas = new ArrayList<Poema>();
	}

	public List<Poema> getPoemas() {
		return poemas;
	}

	public void setPoemas(List<Poema> poemas) {
		this.poemas = poemas;
	}

	@Override
	public String toString() {
		return "ListaPoema [poemas=" + poemas + "]";
	}
	
	
}
