package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScalarAndAggregateFunctions {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emfactory.createEntityManager();
		
		// Scalar function
		Query query = em.createQuery("SELECT UPPER(e.ename) FROM Employee e");
		List<String> list = query.getResultList();
		
		for(String e : list) {
			System.out.println("Employee NAME : " + e);
		}
		
		// Aggregate function
		Query query1 = em.createQuery("SELECT MAX(e.salary) FROM Employee e");
		Double result = (Double) query1.getSingleResult();
		System.out.println("Max Employee Salary : " + result);
		
	}
}
