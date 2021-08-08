package com.controller;

import java.sql.Date;
import java.time.Year;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.HomeOwnerDetails;
import com.bean.LocationDetails;
import com.bean.PropertyDetails;
import com.bean.QuoteDetails;
import com.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "getquote", method = RequestMethod.GET)
	public ModelAndView getquote() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getquote.jsp");
		return mav;
	}

	@RequestMapping(value = "customerhome", method = RequestMethod.GET)
	public ModelAndView customerhome() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerhome.jsp");
		return mav;
	}

	@RequestMapping(value = "retrievequote", method = RequestMethod.GET)
	public ModelAndView retrievequote(HttpSession hs,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		QuoteDetails q = new QuoteDetails();
		LocationDetails l = new LocationDetails();
		HomeOwnerDetails h = new HomeOwnerDetails();
		h=customerService.gethomeownerdetails((String) hs.getAttribute("email"));
		q=customerService.getquotedetailsbyemail((String)hs.getAttribute("email"));
		l=customerService.getlocationdetails((String)hs.getAttribute("email"));
		if(q==null || l==null || h==null)
		{
			mav.addObject("msg", "QUOTE NOT REGISTERED");
			mav.setViewName("customerhome.jsp");
			return mav;
		}
		hs.setAttribute("QuoteDetails", q);
		hs.setAttribute("LocationDetails", l);
		mav.setViewName("retrievequote.jsp");
		mav.addObject("msg","QUOTE RETREIVED SUCCESSFULLLY");
		return mav;
	}

	
	@RequestMapping(value = "homeownerinputdetail.spring", method = RequestMethod.POST)
	public ModelAndView homeownerinputdetail(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		
		HomeOwnerDetails hod = new HomeOwnerDetails();
		hod.setAreyouretired(req.getParameter("rs"));
		Date d1 = Date.valueOf((String) req.getParameter("dob"));
		hod.setDateofBirth(d1);
		hod.setEmailAddress((String) hs.getAttribute("email"));
		hod.setFirstName(req.getParameter("fname"));
		hod.setLastName(req.getParameter("lname"));
		hod.setPassword(req.getParameter("password"));
		hod.setSocialSecurityNumber((int) Long.parseLong(req.getParameter("ssn")));
		hs.setAttribute("email", hod.getEmailAddress());
		String res = customerService.storehomeownerdetails(hod);
		if (res.equals("y")) {
			mav.addObject("msg", "HOMEOWNERDETAILS SUCCESSFULLY ENTERED");
			System.out.println("homeowner details created");
		} else {
			mav.addObject("msg", "HOMEOWNERDETAILS NOT ADDED");
		}
		mav.setViewName("getquote.jsp");
		return mav;
	}

	@RequestMapping(value = "locationinputdetail", method = RequestMethod.POST)
	public ModelAndView lid(HttpServletRequest req, HttpSession hs) {
		
		ModelAndView mav = new ModelAndView();
		
		LocationDetails ld = new LocationDetails();
		ld.setEmail((String)(hs.getAttribute("email")));
		ld.setAddressLine1(req.getParameter("al1"));
		ld.setCity(req.getParameter("city"));
		ld.setResidenceType(req.getParameter("restype"));
		ld.setResidenceUse(req.getParameter("resuse"));
		ld.setState(req.getParameter("state"));
		ld.setZip(req.getParameter("zip"));
		String res = customerService.storelocationdetails(ld);
		if (res.equals("y")) {
			System.out.println("location details added");
			mav.addObject("msg", "LOCATIONDETAILS SUCCESSFULLY ENTERED");
		} else {
			mav.addObject("msg", "LOCATIONDETAILS NOT ADDED");
		}
		mav.setViewName("getquote.jsp");
		return mav;
	}

	@RequestMapping(value = "propertyinputdetail", method = RequestMethod.POST)
	public ModelAndView pid(HttpServletRequest req, HttpSession hs) {
		
		ModelAndView mav = new ModelAndView();
		
		PropertyDetails p = new PropertyDetails();
		p.setEmail((String)hs.getAttribute("email"));
		p.setDwellingStyle(req.getParameter("ds"));
		p.setGarageType(req.getParameter("tog"));
		p.setMarketValue(req.getParameter("mv"));
		p.setNoOfFullBaths(Integer.parseInt(req.getParameter("fb")));
		p.setNoOfHalfBaths(Integer.parseInt(req.getParameter("hfb")));
		p.setPoolAvailable(req.getParameter("pa"));
		p.setRoofMaterial(req.getParameter("rm"));
		p.setSquareFootage(req.getParameter("sf"));
		p.setYear(Integer.parseInt(req.getParameter("yr")));
		String res = customerService.storepropertydetails(p);
		if (res.equals("y")) {
			System.out.println("propertydetails added");
			mav.addObject("msg", "PROPERTYDETAILS SUCCESSFULLY ENTERED");
		} else {
			mav.addObject("msg", "PROPERTYDETAILS NOT ADDED");
		}
		mav.setViewName("getquote.jsp");
		return mav;
	}

	@RequestMapping(value = "displayinputlocationdetails", method = RequestMethod.GET)
	public ModelAndView dipds(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		if (customerService.getlocationdetails((String)hs.getAttribute("email"))!=null ) {
			mav.addObject("msg", "YOU HAVE ALREADY SET YOUR LOCATION DETAILS");
			mav.setViewName("getquote.jsp");
			return mav;
		}
		mav.setViewName("inputlocationdetails.jsp");
		return mav;

	}

	@RequestMapping(value = "displayinputhomeownerdetails", method = RequestMethod.GET)
	public ModelAndView dihod(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		if (customerService.gethomeownerdetails((String)hs.getAttribute("email"))!=null ) {
			mav.addObject("msg", "YOU HAVE ALREADY SET YOUR HOME OWNER DETAILS");
			mav.setViewName("getquote.jsp");
			return mav;
		}
		mav.setViewName("inputhomeownerdetails.jsp");
		return mav;
	}

	@RequestMapping(value = "displayinputpropertydetails", method = RequestMethod.GET)
	public ModelAndView dipd(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		if (customerService.getpropertydetails((String)hs.getAttribute("email"))!=null ) {
			mav.addObject("msg", "YOU HAVE ALREADY SET YOUR PROPERTY DETAILS");
			mav.setViewName("getquote.jsp");
			return mav;
		}
		mav.setViewName("inputpropertydetails.jsp");
		return mav;
	}

	@RequestMapping(value = "displayquoteinfo", method = RequestMethod.GET)
	public ModelAndView dqi(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		LocationDetails l = customerService.getlocationdetails((String)hs.getAttribute("email"));
		PropertyDetails p = customerService.getpropertydetails((String)hs.getAttribute("email"));
		QuoteDetails h = customerService.getquotedetailsbyemail((String)hs.getAttribute("email"));
		if (customerService.gethomeownerdetails((String)hs.getAttribute("email"))!=null && p!=null && l!=null && h==null) {
			QuoteDetails q = new QuoteDetails();
			double mp=5.0/1000*Integer.parseInt(p.getSquareFootage().replaceAll("\\D+", ""));
			switch(l.getResidenceType())
			{
			case "singlefamilyhome":mp=mp+0.5;break;
			case "condo":mp=mp+0.6;break;
			case "duplex":mp=mp+0.6;break;
			case "apartment":mp=mp+0.6;break;
			case "townhouse":mp+=0.7;break;
			case "rowhouse":mp+=0.7;break;
			}
			mp/=12;
			q.setMonthlyPremium(mp);
			double pdc=120*Integer.parseInt(p.getSquareFootage().replaceAll("\\D+", ""));
			double hv;
			int yd = Year.now().getValue() - p.getYear();
			if(yd<5)hv = pdc*0.9;
			else if(yd<10)hv = pdc*0.8;
			else if(yd<20)hv = pdc*0.7;
			else hv=pdc*0.5;
			double dc = (0.5*Integer.parseInt(p.getMarketValue().replaceAll("\\D+", "")))+hv;
			q.setDwellingCoverage(dc);
			q.setDetachedStructures(0.1*dc);
			q.setPersonalProperty(0.6*dc);
			q.setAdditionalLivingExpense(0.2*dc);
			q.setMedicalExpense(5000);
			q.setDeductible(0.1*Integer.parseInt(p.getMarketValue().replaceAll("\\D+", "")));
			QuoteDetails qd1 = customerService.savequotedetails(q,(String)hs.getAttribute("email"));
			if(qd1==null)
			{
				System.out.println("CANT CREATE QUOTE");
				mav.addObject("msg", "NOT ABLE TO CREATE QUOTE");
				mav.setViewName("getquote.jsp");
			}
			else {
			hs.setAttribute("QuoteDetails", qd1);
			mav.setViewName("quoteinfo.jsp");
			}
		} 
		
		else {
			if(h!=null)
			{
				mav.addObject("msg", "QUOTE ALREADY GENERATED USE RETRIEVE QUOTE OPTION");
				mav.setViewName("customerhome.jsp");
			}
			else {
			mav.addObject("msg", "ALL DETAILS ARE NOT ADDED YET");
			mav.setViewName("getquote.jsp");
			}
		}
		return mav;
	}
	@RequestMapping(value = "summaryquote", method = RequestMethod.GET)
	public ModelAndView rq(HttpServletRequest req, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		HomeOwnerDetails h = new HomeOwnerDetails();
		PropertyDetails p = new PropertyDetails();
		h = customerService.gethomeownerdetails((String)hs.getAttribute("email"));
		p = customerService.getpropertydetails((String)hs.getAttribute("email"));
		hs.setAttribute("HomeOwnerDetails", h);
		hs.setAttribute("PropertyDetails", p);
		mav.setViewName("summarypagequote.jsp");
		return mav;
	}
}