package com.lms.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "students")
public class Student {
	
	@Id
	private String id;
	private String pid;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private Number phone;
	private String email;
	private String password;
	
	public Student() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String id) {
		this.pid = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() { return lname; }

	public void setLname(String lname) { this.lname = lname; }

	public String getDob() { return dob; }

	public void setDob(String dob) { this.dob = dob; }

	public String getGender() { return gender; }

	public void setGender(String gender) { this.gender = gender; }

	public Number getPhone() { return phone; }

	public void setPhone(Number phone) { this.phone = phone; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

}