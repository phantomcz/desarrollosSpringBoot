package com.latam.springapp.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Poema {
	
	private String title;
	private String content;
	private String url;
//	private Poet poet;
	
	
	public Poema() {
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
//	public Poet getPoet() {
//		return poet;
//	}
//	public void setPoet(Poet poet) {
//		this.poet = poet;
//	}
	
	@Override
	public String toString() {
		return "Poema [title=" + title + ", content=" + content + ", url=" + url + "]";
	}
	
	
}
