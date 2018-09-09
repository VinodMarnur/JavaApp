package com.candidjava.customer.dao;

import java.util.List;
import java.util.Map;

import com.candidjava.customer.AppCustomer;

public interface AppCustomerDao {
	
	public List<AppCustomer> getCustomers();
	
	public AppCustomer getCustomerByCustomerId(long customerId);
	public Map getCustomerFilterData(String str);
	public Map addUpdate(String str);
}
