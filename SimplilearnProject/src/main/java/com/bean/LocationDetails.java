package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LocationDetails {
	@Id
	private String Email;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	private String  ResidenceType;
	private String	AddressLine1;
	private String	City;
	private String	State;
	private String	Zip;
	private String	ResidenceUse;
	public String getResidenceType() {
		return ResidenceType;
	}
	public void setResidenceType(String residenceType) {
		ResidenceType = residenceType;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public String getResidenceUse() {
		return ResidenceUse;
	}
	public void setResidenceUse(String residenceUse) {
		ResidenceUse = residenceUse;
	} 

}
