package com.appmusic.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.appmusic.entity.Users;

public class UserDaoTest extends BaseDaoTest {
	
	
	private static UserDao userDao;
	
	@BeforeClass
	public static void setUpClass() {
		
		BaseDaoTest.setUpClass();
		userDao= new UserDao(entityManager);
		
		
	}

	@Test
	public void testCreateUsers() {
		 
		 Users user = new Users("Jack","Jack@example.com","Password");
		 
		 Users uRef = userDao.create(user);
		 assertTrue(uRef.getUserId()>0);
		 
		 System.out.println("Object has been persisted !");
		
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersNotField() {
		 
		 Users user = new Users();
		 
		 user = userDao.create(user);
		 
		 System.out.println("Object has been persisted !");
		
	}
	
	@Test
	public void testGetUsers() {
		Users user=userDao.get(19);
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Users user=userDao.get(99);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId= 22;
		userDao.delete(userId);
		Users user=userDao.get(userId);
		assertNull(user);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteUserException() {
		Integer userId= 20;
		userDao.delete(userId);
		Users user=userDao.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers= userDao.listAll();
		assertTrue(listUsers.size()>0);
	}
	
	@Test
	public void testCount() {
		List<Users> listUsers= userDao.listAll();
		long count = listUsers.size();
		long expected = count;
		long actual=userDao.Count();
		assertEquals(expected,actual);
	}
	
	@Test
	public void findByEmail() {
		Users user=	userDao.fingByEmail("John@example.com");
		assertNotNull(user);
	}
	
	@AfterClass
	public static void tearDownClass() {
		BaseDaoTest.tearDownClass();
	}

}
