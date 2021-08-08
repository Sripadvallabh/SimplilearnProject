package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.PolicyDetails;
import com.bean.Policyemail;
import com.bean.QuoteDetails;
import com.bean.quoteemail;

@Repository
public class PolicyDao {
	
	@Autowired
	EntityManagerFactory emf;

	public int putpolicydetails(PolicyDetails pd,String email) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(pd);
		tran.commit();
		
		PolicyDetails c = manager.find(PolicyDetails.class, pd.getPolicyKey());
		
		if(c!=null) {
			Policyemail j = new Policyemail();
			j.setPolicyKey(c.getPolicyKey());
			j.setEmail(email);
			EntityTransaction tranc = manager.getTransaction();
			tranc.begin();
			manager.persist(j);
			tranc.commit();
			return 1;
		}else {
			return 0;
		}
	}

	public PolicyDetails getpolicydetails(int policykey) {
		EntityManager manager=emf.createEntityManager();
		PolicyDetails pd = manager.find(PolicyDetails.class, policykey);
		if(pd!=null) {
		return pd;
		}
		else 
			{return null;}
	}

	public int getpolicykey(String email) {
		EntityManager manager=emf.createEntityManager();
		Policyemail pe = manager.find(Policyemail.class, email);
		if(pe!=null) {
		return pe.getPolicyKey();
		}
		else 
			{return 0;}
	
		
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
