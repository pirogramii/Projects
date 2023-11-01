package com.jspiders.hibnernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibnernatemanytomany.dto.CandidateDTO;
import com.jspiders.hibnernatemanytomany.dto.CourseDTO;

public class CourseCandidateDAO {

	private static EntityManagerFactory factory ;
	private static EntityManager manager ;
	private static EntityTransaction transaction ;
	
	private static void openConnection() {
		
		factory = Persistence.createEntityManagerFactory("manytomany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			transaction.begin();
			
			CourseDTO course1 = new CourseDTO();
			course1.setId(1);
			course1.setName("Core Java");
			course1.setDuration(4);
			
			CourseDTO course2 = new CourseDTO();
			course2.setId(2);
			course2.setName("SQL");
			course2.setDuration(2);
			
			manager.persist(course1);
			manager.persist(course2);
			
			List<CourseDTO> courses = Arrays.asList(course1,course2);
			
			CandidateDTO candidate1 = new CandidateDTO();
			candidate1.setId(1);
			candidate1.setName("Arbaaz");
			candidate1.setEmail("arbu@gmail.com");
			candidate1.setAddress("Bhadgaon");
			candidate1.setCourses(courses);
			
			CandidateDTO candidate2 = new  CandidateDTO();
			candidate2.setId(2);
			candidate2.setName("Harshal");
			candidate2.setEmail("chapri@gmail.com");
			candidate2.setAddress("Parola");
			candidate2.setCourses(courses);
			
			manager.persist(candidate1);
			manager.persist(candidate2);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
	
}
