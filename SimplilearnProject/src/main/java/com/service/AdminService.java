package com.service;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.PolicyDetails;
import com.dao.AdminDao;

@Service
public class AdminService {
@Autowired
AdminDao admindao;

public int getpolicykey(String email) {
	return admindao.getpolicykey(email);
}

public PolicyDetails getpolicydetails(int pkeys)
{
	return admindao.getpolicydetails(pkeys);
}

public String renewpolicy(int parseInt, Date parse) {
	if(admindao.renewpolicy(parseInt,parse)>0)
	{
		return "y";
	}
	else
	{
		return "n";
	}
}

public String cancelpolicy(int pkey) {
	if(admindao.cancelpolicy(pkey)>0)
	{
		return "y";
	}
	else
	{
		return "n";
	}
}
}
