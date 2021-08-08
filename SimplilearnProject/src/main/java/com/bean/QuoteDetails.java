package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuoteDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int QuoteId;
	private double MonthlyPremium;
	private double DwellingCoverage;
	private double DetachedStructures;
	private double 	PersonalProperty;
	private double 	MedicalExpense;
	private double 	AdditionalLivingExpense;
	private double 	Deductible;
	public int getQuoteId() {
		return QuoteId;
	}
	public void setQuoteId(int quoteId) {
		QuoteId = quoteId;
	}
	public double getMonthlyPremium() {
		return MonthlyPremium;
	}
	public void setMonthlyPremium(double monthlyPremium) {
		MonthlyPremium = monthlyPremium;
	}
	public double getDwellingCoverage() {
		return DwellingCoverage;
	}
	public void setDwellingCoverage(double dwellingCoverage) {
		DwellingCoverage = dwellingCoverage;
	}
	public double getDetachedStructures() {
		return DetachedStructures;
	}
	public void setDetachedStructures(double detachedStructures) {
		DetachedStructures = detachedStructures;
	}
	public double getPersonalProperty() {
		return PersonalProperty;
	}
	public void setPersonalProperty(double personalProperty) {
		PersonalProperty = personalProperty;
	}
	public double getMedicalExpense() {
		return MedicalExpense;
	}
	public void setMedicalExpense(double medicalExpense) {
		MedicalExpense = medicalExpense;
	}
	public double getAdditionalLivingExpense() {
		return AdditionalLivingExpense;
	}
	public void setAdditionalLivingExpense(double additionalLivingExpense) {
		AdditionalLivingExpense = additionalLivingExpense;
	}
	public double getDeductible() {
		return Deductible;
	}
	public void setDeductible(double deductible) {
		Deductible = deductible;
	}
	
	

}
