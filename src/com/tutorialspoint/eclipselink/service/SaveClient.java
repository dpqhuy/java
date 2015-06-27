package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.NonTeachingStaff;
import com.tutorialspoint.eclipselink.entity.TeachingStaff;

public class SaveClient {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		
		// Teaching staff entity
		TeachingStaff ts1 = new TeachingStaff(1,"Gopal", "MSc MEd", "Maths");
		TeachingStaff ts2 = new TeachingStaff(2,"Manisha", "MSc BEd", "English");
		
		//Non-Teaching Staff entity
	      NonTeachingStaff nts1=new NonTeachingStaff(3, "Satish", "Accounts");
	      NonTeachingStaff nts2=new NonTeachingStaff(4, "Krishna", "Office Admin");
	      
	      //storing all entities
	      em.persist(ts1);
	      em.persist(ts2);
	      em.persist(nts1);
	      em.persist(nts2);
	      
	      em.getTransaction().commit();
	      
	      em.close();
	      emfactory.close();
	}
}
