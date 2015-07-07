package com.tutorialspoint.eclipselink.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee;

public class OneToMany {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		 //Create Employee1 Entity
		   Employee employee1 = new Employee();
		   employee1.setEname("Satish");
		   employee1.setSalary(45000.0);
		   employee1.setDeg("Technical Writer");

		   //Create Employee2 Entity
		   Employee employee2 = new Employee();
		   employee2.setEname("Krishna");
		   employee2.setSalary(45000.0);
		   employee2.setDeg("Technical Writer");

		   //Create Employee3 Entity
		   Employee employee3 = new Employee();
		   employee3.setEname("Masthanvali");
		   employee3.setSalary(50000.0);
		   employee3.setDeg("Technical Writer");

		   //Store Employee
		   em.persist(employee1);
		   em.persist(employee2);
		   em.persist(employee3);

		   //Create Employeelist
		   List<Employee> emplist = new ArrayList();
		   emplist.add(employee1);
		   emplist.add(employee2);
		   emplist.add(employee3);

		   //Create Department Entity
		   Department department = new Department();
		   department.setName("Development");
		   department.setEmployeeList(emplist);

		   //Store Department
		   em.persist(department);
		
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
}
