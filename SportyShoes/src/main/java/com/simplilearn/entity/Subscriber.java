package com.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscriber {
    
	@Id
	private String id;
	private String name;
	private String password;
	public Subscriber() {
		
		
	}
	public Subscriber(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
}
