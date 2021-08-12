package com.lms.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "students")
public class Student {
	
	@Id
	private String id;
	private String sid;
	private String fname;
	private String lname;
	private String email;
	
	public Student() {}
	
	public String getId() {
		return id;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String id) {
		this.sid = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}