package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.HomeOwnerDetails;
import com.bean.LocationDetails;
import com.bean.PropertyDetails;
import com.bean.QuoteDetails;
import com.dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public String storehomeownerdetails(HomeOwnerDetails cc) {
		if(customerDao.storehomeownerdetails(cc)>0) {
			return "y";
		}else {
			return "n";
		}
	}
	public String storelocationdetails(LocationDetails cc) {
		if(customerDao.storelocationdetails(cc)>0) {
			return "y";
		}else {
			return "n";
		}
	}
	
	public String storepropertydetails(PropertyDetails cc) {
		if(customerDao.storepropertydetails(cc)>0) {
			return "y";
		}else {
			return "n";
		}
	}
	public QuoteDetails savequotedetails(QuoteDetails q,String email) {
		return customerDao.savequotedetails(q, email);
	}
	public LocationDetails getlocationdetails(String attribute) {
		return customerDao.getlocationdetails(attribute);
	}
	public QuoteDetails getquotedetails(String attribute) {
		return customerDao.getquotedetails(attribute);
	}
	public QuoteDetails getquotedetailsbyemail(String attribute) {
		return customerDao.getquotedetailsbyemail(attribute);
	}
	public HomeOwnerDetails gethomeownerdetails(String attribute) {
		return customerDao.gethomeownerdetails(attribute);
	}
	public PropertyDetails getpropertydetails(String attribute) {
		return customerDao.getpropertydetails(attribute);
	}
	
}