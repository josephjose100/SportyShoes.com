package com.simplilearn.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public List<Report> getReportByDate(Date date){
		
		Query query=em.createNativeQuery("select * from report where date=?", Report.class);
		query.setParameter(1, date);
		List<Report> report=query.getResultList();
		return report;
		
	}
	
	
}
