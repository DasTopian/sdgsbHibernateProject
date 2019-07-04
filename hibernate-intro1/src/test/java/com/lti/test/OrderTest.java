package com.lti.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;

public class OrderTest {

	@Test
	public void testAddOrder() throws ParseException {
		
		GenericDao gd=new GenericDao();  
		Order o=new Order();
		Customer c=(Customer)gd.fetchById(Customer.class,1);
		o.setId(1);
		o.setAmount(1000);
		o.setOrderDate(new Date());
		o.setCustomer(c);
		
		gd.save(o);
		
		
		
		
		
	}
	@Test
	public void test() {
		GenericDao dao = new GenericDao();
		List<Order> list=dao.fetchCustomers(Order.class);
		for(Order o:list) {
			System.out.println(o.getCustomer().getName());
			
		}
	}

}
