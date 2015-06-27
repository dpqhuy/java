package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Employee;

public class FindEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		Employee e = em.find(Employee.class, 201);
		
		if(e != null) {
			System.out.println("Employee Eid: " + e.getEid());
			System.out.println("Employee Ename: " + e.getEname());
			System.out.println("Employee Deg: " + e.getDeg());
			System.out.println("Employee Salary: " + e.getSalary());
		} else {
			System.out.println("Employee not found");
		}
		
		em.close();
		emFactory.close();
	}
}
