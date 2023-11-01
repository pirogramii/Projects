package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO {

	private static EntityManagerFactory factory ;
	private static EntityManager manager ;
	private static EntityTransaction transaction ;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("onetoone");
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
			
			PersonDTO person = new PersonDTO();
			person.setId(1);
			person.setName("Sam");
			person.setGender('m');
			person.setAddress("Pune");
			
			AadharDTO aadhar = new AadharDTO();
			aadhar.setId(1);
			aadhar.setAadhar_no(123456789142l);
			aadhar.setDoi("23-05-2001");
			
			person.setAddhar(aadhar);
			manager.persist(person);
			aadhar.setPerson(person);
			manager.persist(aadhar);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
