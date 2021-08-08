package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.HomeOwnerDetails;
import com.bean.LocationDetails;
import com.bean.PropertyDetails;
import com.bean.QuoteDetails;
import com.bean.quoteemail;

@Repository
public class CustomerDao {

	@Autowired
	EntityManagerFactory emf;
	
	public int storehomeownerdetails(HomeOwnerDetails cc) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(cc);
		tran.commit();
		
		HomeOwnerDetails c = manager.find(HomeOwnerDetails.class, cc.getEmailAddress());
		if(c!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	public int storelocationdetails(LocationDetails cc) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(cc);
		tran.commit();
		
		LocationDetails c = manager.find(LocationDetails.class, cc.getEmail());
		if(c!=null) {
			return 1;
		}else {
			return 0;
		}
	}public int storepropertydetails(PropertyDetails cc) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(cc);
		tran.commit();
		
		PropertyDetails c = manager.find(PropertyDetails.class, cc.getEmail());
		if(c!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	public HomeOwnerDetails gethomeownerdetails(String EmailAddress)
	{
		EntityManager manager = emf.createEntityManager();
		HomeOwnerDetails cc = manager.find(HomeOwnerDetails.class,EmailAddress);
		return cc;
	}
	public LocationDetails getlocationdetails(String email)
	{
		EntityManager manager = emf.createEntityManager();
		LocationDetails cc = manager.find(LocationDetails.class,email);
		return cc;
	}
	public PropertyDetails getpropertydetails(String email)
	{
		EntityManager manager = emf.createEntityManager();
		PropertyDetails cc = manager.find(PropertyDetails.class,email);
		return cc;
	}
	public QuoteDetails savequotedetails(QuoteDetails q, String email) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(q);
		tran.commit();
		QuoteDetails cd = manager.find(QuoteDetails.class, q.getQuoteId());
		
		if(cd!=null) {
			quoteemail c = new quoteemail();
			c.setQuoteId(cd.getQuoteId());
			c.setEmail(email);
			EntityTransaction tranc = manager.getTransaction();
			tranc.begin();
			manager.persist(c);
			tranc.commit();
			return cd;
		}else {
			return null;
		}
	}
	public QuoteDetails getquotedetails(String qid)
	{
		EntityManager manager = emf.createEntityManager();
		QuoteDetails cc = manager.find(QuoteDetails.class,qid);
		return cc;
	}
	public QuoteDetails getquotedetailsbyemail(String email)
	{
		EntityManager manager=emf.createEntityManager();
		quoteemail q = manager.find(quoteemail.class, email);
		if(q!=null) {
		QuoteDetails qd = manager.find(QuoteDetails.class, q.getQuoteId());
		return qd;
		}
		else 
			{return null;}
		
	}
	
}