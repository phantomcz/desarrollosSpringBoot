package com.latam.springapp.web.domain;

public class Poet {
	private String name;
	private String url;
	
	public Poet() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Poet [name=" + name + ", url=" + url + "]";
	}
	
	
}
