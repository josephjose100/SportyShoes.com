package com.simplilearn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.simplilearn.entity.Report;
import com.simplilearn.entity.Subscriber;
import com.simplilearn.services.Adminservice;
import com.simplilearn.services.Productservice;
import com.simplilearn.services.Reportservice;
import com.simplilearn.services.Subscriberservice;

@Controller
public class Commoncontroller {

	@Autowired
	Productservice productservice;
	
	@Autowired
	Subscriberservice subscriberservice;
	
	@Autowired
	Adminservice adminservice;
	
	@Autowired
	Reportservice reportservice;
	
	@GetMapping("/sportyshoes")
	public String displayWelcomePage() {
		
		return "welcome";
		
	}
	
	@GetMapping("/change")
	public String changeAdminPassword(HttpSession httpsession) {
		
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		 return "new_password";
		}
		return "welcome";
	}
	
	@GetMapping("/report")
	public String purchaseReportPage(HttpSession httpsession) {
		

		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		return "purchase_report";
		}
		return "welcome";
	}
	
	@GetMapping("/fullreport")
	public String showFullReport(HttpSession httpsession,Model model) {
		
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		
		List<Report> report=reportservice.displayAllReport();
		model.addAttribute("report", report);
		return "purchase_report";
		}
		return "welcome";
	}
	
	
	
	
	@PostMapping("/password")
	public String newPassword(@RequestParam("adminId") String adminId,@RequestParam("password") String password,@RequestParam("password1") String password1,@RequestParam("password2") String password2,Model model,HttpSession httpsession) {
		   
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin1=adminservice.getAdmin();
		if(admin1.getAdminId().equals(adminIdentity)) {
		
		    Admin admin=adminservice.getAdminDetails(adminId);
	    	if(password.equals(admin.getPassword())&&(password1.equals(password2))) {
			admin.setPassword(password1);
			adminservice.updateAdmin(admin);
			List<Product> products=productservice.displayAllProducts();
			model.addAttribute("products",products);
			List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
			model.addAttribute("subscribers",subscribers);
			model.addAttribute("admin",admin);
			return "home";
			
		}
		else {
			model.addAttribute("Message", "Please check the entered values");
			return "new_password";
		}
		}
		return "welcome";
		
	}
	
	
	@RequestMapping(value={"/login"},method= {RequestMethod.POST,RequestMethod.GET})
	public String validateLogin(@ModelAttribute Admin admin,Model model,HttpServletRequest request) {
		
	String adminId=admin.getAdminId();
	String password=admin.getPassword();
	Admin admin1=adminservice.getAdminDetails(adminId);
	if(password.equals(admin1.getPassword())) {
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("adminIdentity", admin1.getAdminId());
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
	}
	else
		return "welcome";
		
	}
	
	@RequestMapping(value="/return",method= {RequestMethod.POST,RequestMethod.GET})
	public String returnHomePage(Model model,HttpSession httpsession) {
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
		}
		return "welcome";
	}
	
	@PostMapping("/search")
	public String searchSubscriber(@RequestParam("id") String id,Model model,HttpSession httpsession) {
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		
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
		return "welcome";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product,Model model,HttpSession httpsession) {
		
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		productservice.addProduct(product);
		return "redirect:/new";
		}
		return "welcome";
		
	}
	
	@GetMapping("/new")
	public String newProductForm(HttpSession httpsession) {
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		return "addProduct";
		}
		return "welcome";
	}
	
	
	@GetMapping("/delete/{pId}")
	public String deleteProduct(@PathVariable("pId") String pId ,Model model,HttpSession httpsession) {
		
		String adminIdentity=(String)httpsession.getAttribute("adminIdentity");
		Admin admin=adminservice.getAdmin();
		if(admin.getAdminId().equals(adminIdentity)) {
		
		productservice.removeProduct(pId);
		List<Product> products=productservice.displayAllProducts();
		model.addAttribute("products",products);
		List<Subscriber> subscribers=subscriberservice.displayAllSubscribers();
		model.addAttribute("subscribers",subscribers);
		return "home";
		}
		return "welcome";
		
	}
	
	
}

