package com.candidjava.customer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.candidjava.customer.AppCustomer;

@Repository
public class AppCustomerDaoImpl implements AppCustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Map map=null;
	JSONObject obj=null;
	@Override
	public List<AppCustomer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AppCustomer.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<AppCustomer> customers = criteria.list();
		
		return customers;
	
	}
	
	@Override
	public AppCustomer getCustomerByCustomerId(long customerId) {
			
			Session session = sessionFactory.getCurrentSession();	
			AppCustomer appCustomer=(AppCustomer) session.get(AppCustomer.class,customerId);
		return appCustomer;

	}

	@Override
	public Map getCustomerFilterData(String str) {
		int pageIndex=0,pageSize=0;
		map=new HashMap();
		String searchValue="";
		String order="desc",orderName="customerId";
		obj=new JSONObject(str);
		if(!obj.isNull("pageIndex")) {
			pageIndex=obj.getInt("pageIndex");
		}
		if(!obj.isNull("pageSize")) {
			pageSize=obj.getInt("pageSize");
		}else {
			pageSize=5;
		}
		
		if(!obj.isNull("searchValue")) {
			searchValue="%"+obj.getString("searchValue")+"%";
		}
		
		System.out.println(searchValue);

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(AppCustomer.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		Criteria dataLength=session.createCriteria(AppCustomer.class);
		dataLength.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(pageIndex*pageSize);
		criteria.setMaxResults(pageSize);
		
		if(searchValue.length()>=5) {
			criteria.add(Restrictions.or(Restrictions.like("customerName", searchValue),
						 Restrictions.like("mob", searchValue),
						 Restrictions.like("email", searchValue)));
			
			dataLength.add(Restrictions.or(Restrictions.like("customerName", searchValue),
					 Restrictions.like("mob", searchValue),
					 Restrictions.like("email", searchValue)));
		}else {
			criteria.addOrder(Order.desc("customerId"));
		}
		
		HashMap meta=new HashMap();
		meta.put("pageIndex", pageIndex);
		meta.put("pageSize", pageSize);
		meta.put("length", dataLength.list().size());
		map.put("meta", meta);
		map.put("data", criteria.list());
		return map;
	}

	@Override
	public Map addUpdate(String str) {
		// TODO Auto-generated method stub
		AppCustomer customer=new AppCustomer();
		obj=new JSONObject(str);
		System.out.println(obj.toString());
		map=new HashMap();
		if(!obj.isNull("customerId")){
			customer.setCustomerId(obj.getLong("customerId"));
		}else {
			customer.setCustomerId(0);
		}
		
		if(!obj.isNull("customerName")){
			customer.setCustomerName(obj.getString("customerName"));
		}
		
		if(!obj.isNull("email")){
			customer.setEmail(obj.getString("email"));
		}
		
		if(!obj.isNull("mob")){
			customer.setMob(obj.getString("mob"));
		}
		
		Session session = sessionFactory.getCurrentSession();
		if(customer.getCustomerId()!=0) {
			session.update(customer);
			map.put("msg", "customer Updated Successfully");
			map.put("actionType", 2);
			
		}else {
			session.save(customer);
			map.put("msg", "customer Added Successfully");
			map.put("actionType", 1);
		}
		
		return map;
	}
	
		
}
