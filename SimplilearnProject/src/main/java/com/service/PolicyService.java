package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PolicyDetails;
import com.bean.QuoteDetails;
import com.dao.PolicyDao;
@Service
public class PolicyService {
	@Autowired
	PolicyDao policydao;
	
	public String putpolicy(PolicyDetails pd,String email) {
		if(policydao.putpolicydetails(pd,email)>0) {
			return "y";
		}else {
			return "n";
		}	
	}

	public PolicyDetails getpolicydetails(int policykey) {
		return policydao.getpolicydetails(policykey);	
	}

	public int getpolicykey(String attribute) {
		return policydao.getpolicykey(attribute);
	}

	public QuoteDetails getquotedetailsbyemail(String attribute) {
		return policydao.getquotedetailsbyemail(attribute);
	}

}
