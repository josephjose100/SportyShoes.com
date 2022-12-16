package com.simplilearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Subscriber;
import com.simplilearn.repository.Subscriberrepository;

@Service
public class Subscriberservice {

	@Autowired
	Subscriberrepository subscriberrepository;
	
	
	public List<Subscriber> displayAllSubscribers(){
		
		return subscriberrepository.getAllSubscribers();	
	}
	
	
	public Subscriber searchSubscriber(String id) {
		
		return subscriberrepository.getSubscriberById(id);
		
		
	}
	
	
	
}
