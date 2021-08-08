package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class quoteemail {
@Id
private String Email;
private int QuoteId;
public String getEmail() {
	return Email;
}
public int getQuoteId() {
	return QuoteId;
}
public void setEmail(String email) {
	Email = email;
}
public void setQuoteId(int quoteId) {
	QuoteId = quoteId;
}
}
