package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Report;
import com.simplilearn.repository.Reportrepository;

@Service
public class Reportservice {

	
	@Autowired
	Reportrepository reportrepository;
	
	public List<Report> displayAllReport(){

		return reportrepository.getAllReport();
	}
	
	public List<Report> displayCategoryReport(String category,String date){

		return reportrepository.getCategoryReport(category,date);
	}
    
	
	
	
}
