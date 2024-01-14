package com.sunbeam.pojos;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Movies {
    
	private int id;
	private String title;
	private Date rel;
	
	public Movies() {
		
	}

	public Movies(int id, String title, Date rel) {
		super();
		this.id = id;
		this.title = title;
		this.rel = rel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRel() {
		return rel;
	}

	public void setRel(Date rel) {
		this.rel = rel;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String relDate = sdf.format(rel);
		return "Movies [id=" + id + ", title=" + title + ", rel=" + rel + "]";
	}
	
   
}
