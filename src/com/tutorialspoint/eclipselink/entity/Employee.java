package com.tutorialspoint.eclipselink.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query = "SELECT e FROM Employee e WHERE e.eid = :id", name = "find employee by id")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int eid;
	private String ename;
	private double salary;
	private String deg;
	
	
	public Employee(int eid, String ename, double salary, String deg) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}
	
	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}
	
	@Override
	public String toString() {
		 return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
	 }
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < Integer.MAX_VALUE/10; i++) {
			// ignore
		}
		System.out.println("time: " + (System.currentTimeMillis() - start));
		
		
		start = System.currentTimeMillis();
		int j = 0;
		while(j < Integer.MAX_VALUE/10) {
			j+=6;
		}
		System.out.println("time 2: " + (System.currentTimeMillis() - start));
	}
}
