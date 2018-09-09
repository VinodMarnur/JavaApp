package com.candidjava.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.customer.AppCustomer;
import com.candidjava.customer.dao.AppCustomerDao;

@Service
@Transactional
public class AppCustomerServiceImpl implements AppCustomerService{

	@Autowired
	AppCustomerDao customerDao;
	
	@Override
	public List<AppCustomer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public AppCustomer getCustomerByCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByCustomerId(customerId);
	}

	@Override
	public Map getCustomerFilterData(String str) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerFilterData(str);
	}

	@Override
	public Map addUpdate(String str) {
		// TODO Auto-generated method stub
		return customerDao.addUpdate(str);
	}

}
