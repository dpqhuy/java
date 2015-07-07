package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee;

public class ManyToOne {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		// Create Department Entity
		Department department = new Department();
		department.setName("Development");
		
		// Store department
		em.persist(department);
		
		//Create Employee1 Entity
		   Employee employee1 = new Employee();
		   employee1.setEname("Satish");
		   employee1.setSalary(45000.0);
		   employee1.setDeg("Technical Writer");
		   employee1.setDepartment(department);

		   //Create Employee2 Entity
		   Employee employee2 = new Employee();
		   employee2.setEname("Krishna");
		   employee2.setSalary(45000.0);
		   employee2.setDeg("Technical Writer");
		   employee2.setDepartment(department);

		   //Create Employee3 Entity
		   Employee employee3 = new Employee();
		   employee3.setEname("Masthanvali");
		   employee3.setSalary(50000.0);
		   employee3.setDeg("Technical Writer");
		   employee3.setDepartment(department);
		   
		
		   // Store Employee
		   em.persist(employee1);
		   em.persist(employee2);
		   em.persist(employee3);
		   
		   em.getTransaction().commit();
		   em.close();
		   emFactory.close();

	}

}
