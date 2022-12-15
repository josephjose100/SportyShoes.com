package com.simplilearn.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.entity.Subscriber;



@Repository
@Transactional
public class Subscriberrepository {

    @Autowired
	EntityManager em;
	
    public List<Subscriber> getAllUsers(){
    	
    	List<Subscriber> subscribers=em.createQuery("select s from Subscriber s").getResultList();
    	return subscribers;
    	
    }
    
    public Subscriber getSubscriberById(String id) {
    	
    	return em.find(Subscriber.class, id);
    	
    }
    
    
    
}
