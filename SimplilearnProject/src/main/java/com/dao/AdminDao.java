package com.dao;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.PolicyDetails;
import com.bean.Policyemail;

@Repository
public class AdminDao {
@Autowired
EntityManagerFactory emf;

	public int getpolicykey(String email) {
		EntityManager manager = emf.createEntityManager();
		Policyemail pe= manager.find(Policyemail.class, email);
		if(pe==null)return 0;
		else
		return pe.getPolicyKey();
	}

	public PolicyDetails getpolicydetails(int pkeys) {
		EntityManager manager = emf.createEntityManager();
		PolicyDetails pd = manager.find(PolicyDetails.class, pkeys);
		return pd;
	}
	public int renewpolicy(int pkey, Date enddate) {
		EntityManager manager = emf.createEntityManager();
		PolicyDetails cc = manager.find(PolicyDetails.class,pkey);
		if(cc==null)return 0;
		Date startdate = cc.getPolicyEndDate();
		if(enddate.compareTo(startdate)<0)return 0;
		cc.setPolicyEffectiveDate(startdate);
		cc.setPolicyTerm(((enddate.getTime()-startdate.getTime())/ (1000 * 60 * 60 * 24))% 365);
		cc.setPolicyEndDate(enddate);
		if(cc.getPolicyStatus()=="Cancelled")return 0;
		cc.setPolicyStatus("Renewed");
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(cc);
		tran.commit();
		PolicyDetails cc2 = manager.find(PolicyDetails.class, cc.getPolicyKey());
		if(cc2!=null)
		return 1;
		else
			return 0;
	}

	public int cancelpolicy(int pkey) {
		EntityManager manager = emf.createEntityManager();
		PolicyDetails cc = manager.find(PolicyDetails.class,pkey);
		if(cc==null)return 0;
		cc.setPolicyStatus("Cancelled");
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(cc);
		tran.commit();
		PolicyDetails cc2 = manager.find(PolicyDetails.class, cc.getPolicyKey());
		if(cc2!=null)
		return 1;
		else
			return 0;
	}

}
