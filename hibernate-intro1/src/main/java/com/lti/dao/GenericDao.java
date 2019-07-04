package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;


public class GenericDao {
	
	public void save(Object obj) {			//insert or update method
		
		EntityManagerFactory emf=null;
		EntityManager em=null;		
				
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
		
				
				em = emf.createEntityManager();
		
				EntityTransaction tx=em.getTransaction();
				tx.begin();
		
				em.merge(obj);
				tx.commit();
		}
		finally {
		em.close();
		emf.close();
		}
	}
	public Object fetchById(Class classname,Object id) {			//fetch records
		EntityManagerFactory emf=null;
		EntityManager em=null;
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
				
				
				em = emf.createEntityManager();
		
				 Object obj=em.find(classname, id); 
				return obj;
		}
		finally {
		em.close();
		emf.close();
		}
		
	}
	//public List<?> fetchCustomers(Class clazz) {
	public <E> List<E> fetchCustomers(Class<E> clazz) {//THIS IS CALLED GENERICS
		EntityManagerFactory emf=null;
		EntityManager em=null;		
				
		try {
				emf = Persistence.createEntityManagerFactory("oracleTest");
		
				
				em = emf.createEntityManager();
		
				// introducing JP-QL(HQL) hibernate query language
				Query q= em.createQuery("select obj from " + clazz.getName()+ " as obj"); 
				List<E> list=q.getResultList();
				return list;
		}
			finally {
		em.close();
		emf.close();
			}
		}
	
	
	
}
