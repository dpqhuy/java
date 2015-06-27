package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Employee;

public class CreateEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Employee employee = new Employee();
		employee.setEid(205);
		employee.setEname("Dong Hung");
		employee.setSalary(600);
		employee.setDeg("Software Engineer");
		
		em.persist(employee);
		em.getTransaction().commit();
		
		em.close();
		emfactory.close();
		
	}
}
