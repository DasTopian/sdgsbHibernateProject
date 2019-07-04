package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;

public class AccountTest {

	@Test
	public void testInsertAccount() {
		
		GenericDao dao = new GenericDao();
		Account a = new Account();
		a.setName("Prakash");
		a.setType("Checking");
		a.setBalance(1500.50);
		dao.save(a);
		
	}
	
	@Test
	public void testShowSelect() {
		
		GenericDao dao = new GenericDao();
		Account ac =(Account) dao.fetchById(Account.class, 161);
		System.out.println(ac.getAcno());
		System.out.println(ac.getName());
		System.out.println(ac.getType());
		System.out.println(ac.getBalance());
		
	}
	
	@Test
	public void testShowAll() {
		
		GenericDao dao = new GenericDao();
		List<Account> list = dao.fetchCustomers(Account.class) ;
		for (Account ac:list) {
			System.out.println("==========================");
			System.out.println(ac.getAcno());
			System.out.println(ac.getName());
			System.out.println(ac.getType());
			System.out.println(ac.getBalance());
			System.out.println("==========================");
		 }
		
			
			
	 }
	
	@Test
	public void testUpdate() {
		
		GenericDao dao = new GenericDao();
		Account acc = (Account)dao.fetchById(Account.class, 161);
		acc.setName("SidNarad");
		dao.save(acc);
		
	}
		


		
 }


