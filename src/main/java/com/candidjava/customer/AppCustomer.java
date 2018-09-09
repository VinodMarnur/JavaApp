package com.candidjava.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="app_customer")
public class AppCustomer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	private String customerName;	
	private String email;
	private String mob;
	private Date dob;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "appCustomer", cascade = CascadeType.ALL)
	List<AppCustomerContact> appCustomerContact;
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	public AppCustomer() {
		
	}

	public AppCustomer(long customerId, String customerName, String email, String mob, Date dob,
			List<AppCustomerContact> appCustomerContact) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.mob = mob;
		this.dob = dob;
		this.appCustomerContact = appCustomerContact;
	}

	public List<AppCustomerContact> getAppCustomerContact() {
		return appCustomerContact;
	}

	public void setAppCustomerContact(List<AppCustomerContact> appCustomerContact) {
		this.appCustomerContact = appCustomerContact;
	}
	
	
	
	
	

	
}
