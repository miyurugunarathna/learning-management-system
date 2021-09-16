package com.lms.api.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "teachers")
public class Teacher {
	
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
	private String title;
	private String description;
	private String university;
	private String bank;
	private String branch;
	private int accnum;
	private String approved;
	private Boolean active;
	
	private String role;
	
	@DBRef
    private Set<Role> roles;
	
	public Teacher() {}
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getAccnum() {
		return accnum;
	}

	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



}