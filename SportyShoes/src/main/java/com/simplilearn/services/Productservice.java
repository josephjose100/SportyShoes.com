package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;
import com.simplilearn.repository.Productrepository;

@Service
public class Productservice {

	@Autowired
	Productrepository productrepository;
	
	public void addProduct(Product product) {
		
		
		productrepository.saveProduct(product);
		
	}
	
	public List<Product> displayAllProducts(){
		
		return productrepository.getAllProduct();
	}
	
	public void removeProduct(String pId) {
		
		productrepository.deleteProduct(pId);
	}
	
	
}
