package com.xadmin.usermanagement.bean;

public class User {
	protected int id;
	protected String name;
	protected String email;
	protected String NIC;
	protected String department;
	protected String designation;
	protected String joinedDate;
	
	public User() {
	}
	
	public User(String name, String email, String NIC, String department, String designation, String joinedDate) {
		super();
		this.name = name;
		this.email = email;
		this.NIC = NIC;
		this.department = department;
		this.designation = designation;
		this.joinedDate = joinedDate;
		
	
		
		
	}

	public User(int id, String name, String email, String NIC, String department, String designation, String joinedDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.NIC = NIC;
		this.department = department;
		this.designation = designation;
		this.joinedDate = joinedDate;
	
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String NIC) {
		this.NIC= NIC;
	}
	public String getdepartment() {
		return department;
	}
	public void setdepartment(String department) {
		this.department= department;
	}
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designation) {
		this.designation=  designation;
	}
	public String getjoinedDate() {
		return joinedDate;
	}
	public void joinedDate(String joinedDate) {
		this.joinedDate= joinedDate;
	}


	
}
