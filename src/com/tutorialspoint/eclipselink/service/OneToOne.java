package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee;

public class OneToOne {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		//Create Department Entity
		   Department department = new Department();
		   department.setName("Development");

		   //Store Department
		   em.persist(department);

		   //Create Employee Entity
		   Employee employee = new Employee();
		   employee.setEname("Satish");
		   employee.setSalary(45000.0);
		   employee.setDeg("Technical Writer");
		   employee.setDepartment(department);

		   //Store Employee
		   em.persist(employee);
		
		em.getTransaction().commit();
	}
}
