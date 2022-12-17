package com.simplilearn.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Report {
    @Id
	private String rId;
	private Date date;
	@OneToOne
	private Product product;
	@OneToOne
	private Subscriber subscriber;
	public Report() {
		
	}
	public Report(String rId, Date date, Product product, Subscriber subscriber) {
		super();
		this.rId = rId;
		this.date = date;
		this.product = product;
		this.subscriber = subscriber;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	@Override
	public String toString() {
		return "Report [rId=" + rId + ", date=" + date + ", product=" + product + ", subscriber=" + subscriber + "]";
	}
	
	
	
}
