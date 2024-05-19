package com.techpalle.model;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String department;
	private String status;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String email, String department, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.status = status;
	}
	
	public Employee(String name, String email, String department, String status) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.status = status;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
