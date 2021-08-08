package com.controller;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.PolicyDetails;
import com.bean.QuoteDetails;
import com.service.PolicyService;

@Controller
public class PolicyController {
	@Autowired
	PolicyService policyservice;

	@RequestMapping(value = "buypolicy", method = RequestMethod.GET)
	public ModelAndView buypolicy(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		if(policyservice.getpolicydetails(policyservice.getpolicykey((String) hs.getAttribute("email")))!=null){
			mav.addObject("msg", "POLICY FOR THE QUOTE ALREADY BOUGHT");
			mav.setViewName("customerhome.jsp");
			return mav;
		}
		if(policyservice.getquotedetailsbyemail((String) hs.getAttribute("email"))==null)
		{
			mav.addObject("msg", "REVIEW YOUR QUOTE FIRST");
			mav.setViewName("customerhome.jsp");
			return mav;
		}
		QuoteDetails q = policyservice.getquotedetailsbyemail((String) hs.getAttribute("email"));
		hs.setAttribute("qid",q.getQuoteId());
		mav.setViewName("buypolicy.jsp");
		return mav;
	}

	@RequestMapping(value = "confirmpolicy", method = RequestMethod.POST)
	public ModelAndView viewpolicy(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		LocalDate d1 = LocalDate.parse((String) req.getParameter("policystartdate"));
		LocalDate now = LocalDate.now();
		LocalDate d2 = LocalDate.parse((String) req.getParameter("policyenddate"));
		Period diff = Period.between(d1, d2);
		if(d1.compareTo(now)>60 || d1.compareTo(now)<0 || d2.compareTo(d1)<0)
		{
			mav.addObject("msg", "ENTER PROPER POLICY DATE");
			mav.setViewName("buypolicy.jsp");
			return mav;
		}
		PolicyDetails pd = new PolicyDetails();
		int qid = policyservice.getquotedetailsbyemail((String)hs.getAttribute("email")).getQuoteId();
		pd.setQuoteId(qid);
		pd.setPolicyEffectiveDate(Date.valueOf(d1));
		pd.setPolicyEndDate(Date.valueOf(d2));
		pd.setPolicyTerm(diff.getDays());
		pd.setPolicyStatus("Active");
		hs.setAttribute("pd", pd);
		if (policyservice.putpolicy(pd,(String)hs.getAttribute("email")) == "y") {
			System.out.println("policy created");
			mav.addObject("msg", "BUY POLICY SUCCESSFUL");
			mav.setViewName("viewpolicy.jsp");
		} else {
			mav.addObject("msg", "BUY POLICY UNSUCCESSFUL");
			mav.setViewName("customerhome.jsp");
		}
		return mav;
	}

	@RequestMapping(value = "viewpolicyuser", method = RequestMethod.GET)
	public ModelAndView vp(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		int pkey = policyservice.getpolicykey((String) hs.getAttribute("email"));
		PolicyDetails pd = policyservice.getpolicydetails(pkey);
		if (pd != null) {
			mav.addObject("msg", "POLICYDETAILS SUCCESSFULLY RETRIEVED");
			hs.setAttribute("pd", pd);
			mav.setViewName("viewpolicy.jsp");
		} else {
			mav.addObject("msg", "POLICYDETAILS RETREIVAL UNSUCCESSFUL");
			mav.setViewName("customerhome.jsp");
		}
		return mav;
	}

	@RequestMapping(value = "renewpolicyuser", method = RequestMethod.GET)
	public ModelAndView rpu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("renewpolicyuser.jsp");
		return mav;
	}

	

	@RequestMapping(value = "cancelpolicyuser", method = RequestMethod.GET)
	public ModelAndView cpu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cancelpolicyuser.jsp");
		return mav;
	}


}
