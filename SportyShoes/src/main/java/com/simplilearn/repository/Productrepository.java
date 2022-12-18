package com.simplilearn.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.entity.Product;
import com.simplilearn.entity.Report;

@Repository
@Transactional
public class Productrepository {

	@Autowired
	EntityManager em;

	public void saveProduct(Product product) {
		em.persist(product);

	}

	public List<Product> getAllProduct() {

		List<Product> products = em.createQuery("select p from Product p").getResultList();
		return products;
	}

	public Product getProductByID(String pId) {
		return em.find(Product.class, pId);
	}

	public void deleteProduct(String pId) {
      try {
		Product product = getProductByID(pId);
		em.remove(product);
		}
      catch(Exception e) {
    	  
    	  e.printStackTrace();
      }
	}
}
