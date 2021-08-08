package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Policyemail {
@Id
private String Email;
private int PolicyKey;
public String getEmail() {
	return Email;
}
public int getPolicyKey() {
	return PolicyKey;
}
public void setEmail(String email) {
	Email = email;
}
public void setPolicyKey(int policyKey) {
	PolicyKey = policyKey;
}

}
