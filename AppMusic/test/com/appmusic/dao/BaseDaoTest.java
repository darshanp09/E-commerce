package com.appmusic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDaoTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	public static void setUpClass() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("AppMusic");
		entityManager=entityManagerFactory.createEntityManager();
	}
	
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
