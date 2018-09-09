package com.candidjava.customer.service;

import java.util.List;
import java.util.Map;

import com.candidjava.customer.AppCustomer;

public interface AppCustomerService {

	public List<AppCustomer> getCustomers();
	public AppCustomer getCustomerByCustomerId(long customerId);
	Map getCustomerFilterData(String str);
	Map addUpdate(String str);
}
