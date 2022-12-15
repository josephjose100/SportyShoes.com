package com.simplilearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simplilearn.entity.Subscriber;
import com.simplilearn.repository.Subscriberrepository;

@SpringBootApplication
public class SportyShoesApplication implements CommandLineRunner {
 
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	

	//private Productrepository productrepository;
	
	@Autowired	
	private Subscriberrepository subscriberrepository;
	
	
	//private Adminrepository adminrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		
	/*	productrepository.saveProduct(new Product("P1","Nike Alpharun","Sports shoe"));
		productrepository.saveProduct(new Product("P2","Adidas Walk","Casual shoe"));
		productrepository.saveProduct(new Product("P3","Woodland Brownie","Formal shoe"));
		
		productrepository.deleteProduct("P2");
		
		*/
		
		
		/*Subscriber subscriber=subscriberrepository.getSubscriberById("S2");
		logger.info("User A2 -> {}",subscriber);
		*/
		
		List<Subscriber> subscribers=subscriberrepository.getAllUsers();
		logger.info("List of all subscribers -> {}",subscribers);
		
	/*	Admin admin=adminrepository.findAdminById("A1");
		logger.info("Admin A1 -> {}",admin);
		adminrepository.deleteAdminById("A2");
		adminrepository.saveAdmin(new Admin("A1","jahangir","qwe"));
		adminrepository.saveAdmin(new Admin("A4","luke","qaz"));
		*/
		
		
		
		
		
		
	}

}
