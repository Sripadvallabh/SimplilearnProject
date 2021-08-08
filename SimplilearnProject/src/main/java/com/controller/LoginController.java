package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView openLoginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public ModelAndView storeHomeOwnerDetails(HttpServletRequest req,Login login,HttpSession session) {
		login.setEmail(req.getParameter("email"));
		login.setPassword(req.getParameter("password"));
		login.setTypeOfUser(req.getParameter("typeOfUser"));
		
		ModelAndView mav = new ModelAndView();
		if(login.getTypeOfUser().equals("admin")) {
			String adminResult = loginService.checkAdminUser(login);
			if(adminResult.equals("success")) {
						session.setAttribute("email", "admin");
						mav.setViewName("adminhome.jsp");
			}else {
				mav.addObject("msg", "Invalid username or password");
				mav.setViewName("index.jsp");
			}
		}else {
			String customerResult = loginService.checkCustomerUser(login);
			if(customerResult.equals("success")) {
				session.setAttribute("email", login.getEmail());
				mav.addObject("msg", "LOGIN SUCCESSFUL");
				mav.setViewName("customerhome.jsp");
			}else {
				mav.addObject("msg", "Invalid username or password");
				mav.setViewName("index.jsp");
			}
		}
		return mav;
	}
	

	@RequestMapping(value = "customersu.spring",method = RequestMethod.POST)
	public ModelAndView customersu(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		Login ll = new Login();
		ll.setEmail((String) req.getParameter("email"));
		ll.setPassword((String) req.getParameter("password"));
		ll.setTypeOfUser("customer");
		String sreq=loginService.newCustomerUser(ll);
		if(sreq=="success")
		{
		mav.addObject("msg", "SIGNUP SUCCESSFUL");
		mav.setViewName("index.jsp");
		}
		else if(sreq=="exists")
		{
			mav.addObject("msg", "EMAIL ALREADY REGISTERED");
			mav.setViewName("index.jsp");
		}
		else
		{
			mav.addObject("msg", "SIGNUP FAILED TRYAGAIN ");
			mav.setViewName("index.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "csu",method = RequestMethod.GET)
	public ModelAndView adminDashboard() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customersignup.jsp");
		return mav;
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		hs.invalidate();
		mav.addObject("msg","YOU HAVE LOGGED OUT SUCCESSFULLY");
		mav.setViewName("index.jsp");
		return mav;
	}
}