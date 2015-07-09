package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.tutorialspoint.eclipselink.entity.Employee;

public class CriteriaAPI {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Employee> from = criteriaQuery.from(Employee.class);
		
		// select all records
		System.out.println("Select all records");
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultList = typedQuery.getResultList();
		
		for(Object o : resultList) {
			Employee e = (Employee) o;
			System.out.println("EID: " + e.getEid() + " Ename: " + e.getEname());
		}
		
		// ordering the records
		System.out.println("Select all records by following ordering");
		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("ename")));
		TypedQuery<Object> typedQuery1 = em.createQuery(select1);
		List<Object> resultList1 = typedQuery1.getResultList();
		
		for(Object o : resultList1) {
			Employee e = (Employee) o;
			System.out.println("EID: " + e.getEid() + " Ename: " + e.getEname());
		}
		
		em.close();
		emFactory.close();
	}
}
