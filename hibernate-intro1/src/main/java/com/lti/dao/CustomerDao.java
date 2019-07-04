package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.lti.entity.Customer;

public class CustomerDao {
	

	/*public void databaseMeAddKaro(Customer customer) {
		//Step 1. Load/Create EntityManagerFactory object
		//During this step, META-INF/persistence.xml is read
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
		
		//Step 2. Load/create EntityManager object 
		
				
				em  = emf.createEntityManager();
		
		//Step 3. Start/Participate in a transaction 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever you want
		em.persist(customer);	//persist method generate insert query
		tx.commit();
		}
		finally {
		//below code should be in finally block
		em.close();
		emf.close();
		}
		
		}*/
	public Customer databaseIlVangudhal(int custId) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
		
				
				em = emf.createEntityManager();
		
				Customer c=em.find(Customer.class, custId); 
				return c;
		}
		
		finally {
		em.close();
		emf.close();
		}
		
	}
	public void databaseInsertUpdate(Customer customer) {
		EntityManagerFactory emf=null;
		EntityManager em=null;		
				
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
		
				
				em = emf.createEntityManager();
		
				EntityTransaction tx=em.getTransaction();
				tx.begin();
		
				em.merge(customer);
				tx.commit();
		}
		finally {
		em.close();
		emf.close();
		}
	}
public List<Customer> databaseIlVangudhal() {
		EntityManagerFactory emf=null;
		EntityManager em=null;		
			
	try {
			emf =Persistence.createEntityManagerFactory("oracleTest");
	
			
			em = emf.createEntityManager();
	
      // introducing JP-QL(HQL) hibernate query language
			Query q= em.createQuery("select c from Customer c"); //similar to select * from table // select class name
			List<Customer> list=q.getResultList();
			return list;
	}
	
	finally {
	em.close();
	emf.close();
	}
	
}

public List<Customer> fetchCustomersByEmail(String email) {
	EntityManagerFactory emf=null;
	EntityManager em=null;		
			
	try {
			emf = Persistence.createEntityManagerFactory("oracleTest");
	
			
			em = emf.createEntityManager();
	
			// introducing JP-QL(HQL) hibernate query language
			Query q= em.createQuery("select c from Customer c where c.email like :em"); //similar to select * from table // select class name
			//Query q= em.createQuery("select c from Customer c where c.email like %:em.%");
			//q.setParameter(1, email);
			q.setParameter("em", "%" + email + "%");
			List<Customer> list=q.getResultList();
			return list;
	}
		finally {
	em.close();
	emf.close();
		}
	}
}