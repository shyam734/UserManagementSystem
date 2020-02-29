package com.userManagement.model;

public class User {
	private int id=0;
	private String name=null;
	private String address=null;
	private int age=0;
	private String email=null;
	
	
	
	public User(int id,String name,String address, int age,String email) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
		this.email=email;
	}

	public User(String name,String address, int age,String email) {
		this.name=name;
		this.age=age;
		this.address=address;
		this.email=email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
