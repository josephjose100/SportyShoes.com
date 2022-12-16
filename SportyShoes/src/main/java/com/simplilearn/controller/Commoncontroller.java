package com.simplilearn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.Product;
import com.simplilearn.entity.Subscriber;
import com.simplilearn.services.Adminservice;
import com.simplilearn.services.Productservice;
import com.simplilearn.services.Subscriberservice;

@Controller
public class Commoncontroller {

	@Autowired
	Productservice productservice;
	
	@Autowired
	Subscriberservice subscriberservice;
	
	@Autowired
	Adminservice adminservice;
	
	@GetMapping("/sportyshoes")
	public String displayWelcomePage() {
		
		return "welcome";
		
	}
	
	
	@RequestMapping(value={"/login"},method= {RequestMethod.POST,RequestMethod.GET})
	public String validateLogin(@ModelAttribute Admin admin,Model model,HttpSession httpsession) {
		
	String adminId=admin.getAdminId();
	String password=admin.getPassword();
	Admin admin1=adminservice.getAdminDetails(adminId);
	if(password.equals(admin1.getPassword())) {
		httpsession.setAttribute("admin", admin1);
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		model.addAttribute("admin",admin);
	
		return "home";
	}
	else
		return "welcome";
		
	}
	
	@RequestMapping(value="/return",method= {RequestMethod.POST,RequestMethod.GET})
	public String returnHomePage(Model model,HttpSession httpsession) {
		
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
		
	}
	
	@PostMapping("/search")
	public String searchSubscriber(@RequestParam("id") String id,Model model,HttpSession httpsession) {
		Subscriber subscriber=subscriberservice.searchSubscriber(id);
		String name=subscriber.getName();
		String password=subscriber.getPassword();
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("password",password);
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product,Model model,HttpSession httpsession) {
		
		productservice.addProduct(product);
		
		
		return "redirect:/new";
		
	}
	
	@GetMapping("/new")
	public String newProductForm(HttpSession httpsession) {
		
		
		return "addProduct";
	}
	
	
	@GetMapping("/delete/{pId}")
	public String deleteProduct(@PathVariable("pId") String pId ,Model model,HttpSession httpsession) {
		
		
		productservice.removeProduct(pId);
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
		
	}
	
	
}

