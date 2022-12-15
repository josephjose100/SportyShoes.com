package com.simplilearn.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.entity.Admin;

@Repository
@Transactional
public class Adminrepository {

	@Autowired
	EntityManager em;
	
	public Admin findAdminById(String adminId) {
		
		return em.find(Admin.class, adminId);
	}
	
	
	public void deleteAdminById(String adminId) {
		
		Admin admin=findAdminById(adminId);
		em.remove(admin);
	}
	
	
	public Admin saveAdmin(Admin admin) {
		
		if(findAdminById(admin.getAdminId())==null) {
			em.persist(admin);
		}
		else {
			em.merge(admin);
		}
		
		return admin;
	}
	
}
