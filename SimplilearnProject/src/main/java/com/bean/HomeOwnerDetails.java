package com.bean;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class HomeOwnerDetails {
	private String FirstName;
	private String	LastName;
	private Date DateofBirth;
	private String	Areyouretired;
	private int	SocialSecurityNumber;
	@Id
	private String	EmailAddress;
	private String  Password;
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(Date d1) {
		DateofBirth = d1;
	}
	public String getAreyouretired() {
		return Areyouretired;
	}
	public void setAreyouretired(String areyouretired) {
		Areyouretired = areyouretired;
	}
	public int getSocialSecurityNumber() {
		return SocialSecurityNumber;
	}
	public void setSocialSecurityNumber(int socialSecurityNumber) {
		SocialSecurityNumber = socialSecurityNumber;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

}
