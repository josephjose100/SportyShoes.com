package com.simplilearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Admin;
import com.simplilearn.repository.Adminrepository;

@Service
public class Adminservice {

	@Autowired
	Adminrepository adminrepository;
	
	public Admin getAdminDetails(String adminId) {
		
		return adminrepository.findAdminById(adminId);
		
	}
	
	public Admin updateAdmin(Admin admin) {
		
		
		return adminrepository.saveAdmin(admin);
		
	}
	
	
	public Admin getAdmin() {
		
		return adminrepository.getAdmin();
	}
	
}
