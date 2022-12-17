package com.simplilearn.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.entity.Report;

@Repository
@Transactional
public class Reportrepository {

	@Autowired
	EntityManager em;

	
	public List<Report> getAllReport(){
		
		List<Report> report=em.createQuery("select r from Report r").getResultList();
		return report;
		
		
	}
	
  public List<Report> getCategoryReport(String category){
	  

		List<Report> reports=em.createQuery("select r from Report r").getResultList();
	   List<Report> report=new ArrayList<>();		
		for(Report r:reports) {
			
			if(r.getProduct().getCategory().equals(category)) {
				
				report.add(r);
			}
			
		}
	  return report;
  }
  
  public List<Report> getDateReport(String date){
		
		List<Report> reports=em.createQuery("select r from Report r").getResultList();
		List<Report> report=new ArrayList<>();	
           for(Report r:reports) {
			
			if(r.getDate().equals(date)) {
				report.add(r);
			}
			
		}
		
		
		return report;
		
		
	}
  
	
}
