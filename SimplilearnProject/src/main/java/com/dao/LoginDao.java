package com.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.HomeOwnerDetails;
import com.bean.Login;
import com.bean.QuoteDetails;

@Repository
public class LoginDao {

	
	@Autowired
	EntityManagerFactory emf;
	
	public int checkLoginDetails(Login ll) {
		
		EntityManager manager = emf.createEntityManager();
		String hql = "FROM Login C WHERE C.email=:email AND C.password=:pwd";
		Query query = manager.createQuery(hql);
		query.setParameter("email", ll.getEmail());
		query.setParameter("pwd", ll.getPassword());
		List<Login> list= query.getResultList();
		return list.size();
	}

	public int putLoginDetails(Login ll) {
		EntityManager manager = emf.createEntityManager();
		Login cc = manager.find(Login.class,ll.getEmail());
		if(cc==null) {
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(ll);
		tran.commit();
		Login c = manager.find(Login.class, ll.getEmail());
		if(c!=null) {
			return 1;
		}else {
			return 0;
		}
		}
		else
		{
			return -1;
		}
	}
}
