package com.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private String pId;
	private String pName;
	private String category;
	public Product() {
	
	}
	public Product(String pId, String pName, String category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.category = category;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", category=" + category + "]";
	}
	
	
	
}
