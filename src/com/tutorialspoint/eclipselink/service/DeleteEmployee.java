package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, 201);
		em.remove(e);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
}
