package com.jspiders.jpql.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.jpql.dto.TrainerDTO;

public class TrainerDAO {
	
	private static EntityManagerFactory factory ;
	private static EntityManager manager ;
	private static EntityTransaction transaction ;
	private static Query query ;
	private static String jpql ;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("jpql");
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
			
			TrainerDTO trainer = new TrainerDTO();
			
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}

	}

}
