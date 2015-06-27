package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Employee;

public class BetweenAndLikeFunctions {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emfactory.createEntityManager();
		
		//Between
		Query query = em.createQuery("SELECT e " + 
							"FROM Employee e " +
							"WHERE e.salary " +
							"Between 600 AND 900");
		
		List<Employee> list = query.getResultList();
		
		for(Employee e : list) {
			System.out.print("Employee ID : " + e.getEid());
			System.out.println("\tEmployee salary : " + e.getSalary());
		}
		
		//Like
		Query query1 = em.createQuery("SELECT e " +
									"FROM Employee e " +
									"WHERE e.ename " +
									"LIKE 'Q%'");
		List<Employee> list1 = query1.getResultList();
		
		for(Employee e : list1) {
			System.out.print("Employee ID : " + e.getEid());
			System.out.println("\tEmployee name : " + e.getEname());
		}
		
	}
}
