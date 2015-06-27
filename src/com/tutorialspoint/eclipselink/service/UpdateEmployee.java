package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Employee e = em.find(Employee.class, 201);
		if(e != null) {
			// before update
			System.out.println(e);
			e.setDeg("Leader");
			em.getTransaction().commit();
			// after update
			System.out.println(e);
		}
		em.close();
		emFactory.close();
		
	}
}
