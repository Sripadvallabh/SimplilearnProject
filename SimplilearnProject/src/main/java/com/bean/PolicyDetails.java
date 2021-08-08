package com.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PolicyDetails {
private int QuoteId;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int PolicyKey;
private Date PolicyEffectiveDate;
private Date PolicyEndDate;
private long PolicyTerm;
private String PolicyStatus;
public int getQuoteId() {
	return QuoteId;
}
public void setQuoteId(int quoteId) {
	QuoteId = quoteId;
}
public int getPolicyKey() {
	return PolicyKey;
}
public void setPolicyKey(int policyKey) {
	PolicyKey = policyKey;
}
public Date getPolicyEffectiveDate() {
	return PolicyEffectiveDate;
}
public void setPolicyEffectiveDate(Date policyEffectiveDate) {
	PolicyEffectiveDate = policyEffectiveDate;
}
public Date getPolicyEndDate() {
	return PolicyEndDate;
}
public void setPolicyEndDate(Date policyEndDate) {
	PolicyEndDate = policyEndDate;
}
public long getPolicyTerm() {
	return PolicyTerm;
}
public void setPolicyTerm(long policyTerm) {
	PolicyTerm = policyTerm;
}
public String getPolicyStatus() {
	return PolicyStatus;
}
public void setPolicyStatus(String policyStatus) {
	PolicyStatus = policyStatus;
}
}
