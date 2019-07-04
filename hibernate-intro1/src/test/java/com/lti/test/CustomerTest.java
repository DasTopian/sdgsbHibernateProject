package com.lti.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerTest {
	Calendar cal = Calendar.getInstance();
    
	@Test
	public void testAdd() throws ParseException {
		
		Customer c=new Customer();
	
		c.setName("sid");
		c.setEmail("sid@narad.com");
		c.setCity("chennai");
		String d="04/10/1997";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		  Date dt=sdf.parse(d);
		    java.sql.Date dob=new java.sql.Date(dt.getTime());
		
		c.setDateOfBirth(dob);
		
		CustomerDao dao=new CustomerDao();
		dao.databaseInsertUpdate(c);
	}
@Test
public void testFetch() {
	CustomerDao dao=new CustomerDao();
	Customer cust=dao.databaseIlVangudhal(24);
	
	System.out.println(cust.getName());
	System.out.println(cust.getEmail());
	System.out.println(cust.getDateOfBirth());
	System.out.println(cust.getCity());
}
@Test
public void testUpdate() {
	CustomerDao dao=new CustomerDao();
	Customer cust=dao.databaseIlVangudhal(24);
	cust.setName("Neha");
	dao.databaseInsertUpdate(cust);
	
	System.out.println(cust.getName());
	System.out.println(cust.getEmail());
	System.out.println(cust.getDateOfBirth());
	System.out.println(cust.getCity());
	
}
@Test
public void testSelect() {
	CustomerDao dao=new CustomerDao();
	List<Customer> cust=dao.databaseIlVangudhal();
	for(Customer c: cust)
		System.out.println(c);

}
@Test
public void testEmail() {
	CustomerDao dao=new CustomerDao();
	List<Customer> cust=dao.fetchCustomersByEmail("gmail");
	for(Customer c: cust)
		System.out.println(c);

}

}
