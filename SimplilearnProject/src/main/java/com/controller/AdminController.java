package com.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.PolicyDetails;
import com.service.AdminService;
import com.service.PolicyService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminservice;
	PolicyService policyservice;

	@RequestMapping(value = "searchadmin", method = RequestMethod.POST)
	public ModelAndView suser(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		int pkey = adminservice.getpolicykey((String) req.getParameter("email"));
		if (pkey == 0) {
			mav.addObject("msg", "NO POLICY FOR THE GIVEN EMAIL");
			mav.setViewName("adminhome.jsp");
			return mav;
		}
		hs.setAttribute("useremail", req.getParameter("email"));
		PolicyDetails pd = adminservice.getpolicydetails(pkey);
		hs.setAttribute("pd", pd);
		mav.setViewName("adminview.jsp");
		return mav;
	}

	@RequestMapping(value = "getstartedadmin", method = RequestMethod.GET)
	public ModelAndView getstarted(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminhome.jsp");
		return mav;
	}

	@RequestMapping(value = "renewpolicyadmin", method = RequestMethod.GET)
	public ModelAndView renewpolicy(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("renewpolicyadmin.jsp");
		return mav;
	}

	@RequestMapping(value = "cancelpolicyadmin", method = RequestMethod.GET)
	public ModelAndView cancelpolicy(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cancelpolicyadmin.jsp");
		return mav;
	}

	@RequestMapping(value = "renewconfirmadmin", method = RequestMethod.POST)
	public ModelAndView prco(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		int pkey = adminservice.getpolicykey((String) hs.getAttribute("useremail"));
		Date d1 = Date.valueOf(req.getParameter("penddate"));
		if (adminservice.renewpolicy(pkey,d1) == "y") {
			mav.addObject("msg", "POLICY RENEWAL SUCCESSFUL");
			mav.setViewName("adminhome.jsp");
			return mav;
		} else {
			mav.addObject("msg", "POLICY RENEWAL UNSUCCESSFUL");
			mav.setViewName("adminhome.jsp");
			return mav;
		}
	}

	@RequestMapping(value = "cancelconfirmadmin", method = RequestMethod.POST)
	public ModelAndView cpa(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		int pkey = adminservice.getpolicykey((String) hs.getAttribute("useremail"));
		if (adminservice.cancelpolicy(pkey) == "y") {
			mav.addObject("msg", "POLICY CANCELLATION SUCCESSFUL");
			mav.setViewName("adminhome.jsp");
			return mav;
		} else {
			mav.addObject("msg", "POLICY CANCELLATION UNSUCCESSFUL");
			mav.setViewName("adminhome.jsp");
			return mav;
		}
	}
}
