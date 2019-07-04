package com.lti.test;



import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Customer;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class PaymentTest {

	@Test
	public void addPaymentTest() {
		
		GenericDao gd=new GenericDao();
		Payment payment=new Payment();
		
		
		
		payment.setAmount(2000);
		payment.setMode("Net Banking");
		payment.setStatus("OK");
		gd.save(payment);
		
		
	}
	
	@Test
	public void linkPaymentTest() {
		
			GenericDao gd=new GenericDao();
		
			Order order=(Order) gd.fetchById(Order.class,101);
		
			Payment payment=(Payment)gd.fetchById(Payment.class,121);
		
			order.setPayment(payment);
		
			gd.save(order);
		
		
		
	}


}
