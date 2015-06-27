package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Employee;

public class NamedQueries {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emfactory.createEntityManager();
		Query query = em.createNamedQuery("find employee by id");
		
		query.setParameter("id", 204);
		
		List<Employee> list = query.getResultList();
		
		for(Employee e : list) {
			System.out.print("Employee ID: " + e.getEid());
			System.out.println("\tEmployee Name: " +  e.getEname());
		}
		
	}
}
