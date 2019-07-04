package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

public class TransactionTest {

	@Test
	public void testAddTransaction() {
		
		GenericDao dao = new GenericDao();
		Transaction t = new Transaction();
		Account acc = (Account)dao.fetchById(Account.class, 161);
		
		
	}

}
