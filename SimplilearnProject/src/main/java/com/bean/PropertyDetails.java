package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PropertyDetails {
	@Id
private String Email;
public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
private String MarketValue;
private int Year;
private String SquareFootage;
private String DwellingStyle;
private String RoofMaterial;
private String GarageType;
private int NoOfFullBaths;
private int NoOfHalfBaths;
public String getMarketValue() {
	return MarketValue;
}
public void setMarketValue(String marketValue) {
	MarketValue = marketValue;
}
public int getYear() {
	return Year;
}
public void setYear(int year) {
	Year = year;
}
public String getSquareFootage() {
	return SquareFootage;
}
public void setSquareFootage(String squareFootage) {
	SquareFootage = squareFootage;
}
public String getDwellingStyle() {
	return DwellingStyle;
}
public void setDwellingStyle(String dwellingStyle) {
	DwellingStyle = dwellingStyle;
}
public String getRoofMaterial() {
	return RoofMaterial;
}
public void setRoofMaterial(String roofMaterial) {
	RoofMaterial = roofMaterial;
}
public String getGarageType() {
	return GarageType;
}
public void setGarageType(String garageType) {
	GarageType = garageType;
}
public int getNoOfFullBaths() {
	return NoOfFullBaths;
}
public void setNoOfFullBaths(int noOfFullBaths) {
	NoOfFullBaths = noOfFullBaths;
}
public int getNoOfHalfBaths() {
	return NoOfHalfBaths;
}
public void setNoOfHalfBaths(int noOfHalfBaths) {
	NoOfHalfBaths = noOfHalfBaths;
}
public String getPoolAvailable() {
	return PoolAvailable;
}
public void setPoolAvailable(String poolAvailable) {
	PoolAvailable = poolAvailable;
}
private String PoolAvailable;
}
