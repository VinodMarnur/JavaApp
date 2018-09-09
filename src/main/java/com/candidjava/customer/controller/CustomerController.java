package com.candidjava.customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.candidjava.customer.AppCustomer;
import com.candidjava.customer.AppCustomerContact;
import com.candidjava.customer.service.AppCustomerService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class CustomerController {
		
	
	@Autowired
	AppCustomerService appCustomerService;
	
	
	
	@RequestMapping(value="/customers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppCustomer> getCustomers(@RequestBody String str) {
		return appCustomerService.getCustomers();
	}
	
	@GetMapping(value="/customer/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppCustomer getCustomerById(@PathVariable long customerId) {
		return appCustomerService.getCustomerByCustomerId(customerId);
	}
	
	@PostMapping(value="/filter-customer")
	public Map customerFilter(@RequestBody String str) {
		return appCustomerService.getCustomerFilterData(str);
	}
	
	@PostMapping(value="/add-update-customer")
	public Map addUpdate(@RequestBody String str) {
		return appCustomerService.addUpdate(str);
	}
	
	@PostMapping(value="/check-customer-exist")
	public Map checkCustomerExist(@RequestBody String str) {
		return null;
	}
	
}
