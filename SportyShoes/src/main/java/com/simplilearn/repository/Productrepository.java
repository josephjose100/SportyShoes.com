package com.simplilearn.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.entity.Product;

@Repository
@Transactional
public class Productrepository {

    
	@Autowired
	EntityManager em;
	
	public void saveProduct(Product product) {
		em.persist(product);
	}
	
	
	public Product getProductByID(String pId) {	
		return em.find(Product.class, pId);
	}
	
	
	public void deleteProduct(String pId) {
		Product product=getProductByID(pId);
		em.remove(product);
	}
	
}
