package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public String checkAdminUser(Login login) {
		if(login.getEmail().equals("root@gmail.com") && login.getPassword().equals("root")) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	public String checkCustomerUser(Login login) {
		if(loginDao.checkLoginDetails(login) > 0) {
			return "success";
		}else {
			return "failure";
		}
	}

	public String newCustomerUser(Login ll) {
		int a = loginDao.putLoginDetails(ll);
		if(a>0)
			return "success";
		else if(a==0)
			return "failure";
		else
			return "exists";
	}
}