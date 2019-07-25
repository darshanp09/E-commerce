package com.appmusic.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.appmusic.entity.Category;

public class CategoryDaoTest extends BaseDaoTest  {

	
	private static CategoryDao categoryDao;
	
	@BeforeClass
	public static void setUpClass() {
		
		BaseDaoTest.setUpClass();
		categoryDao= new CategoryDao(entityManager);
		
		
	}
	
	

	@Test
	public void testCreateCategory() {
		Category category = new Category("Python");
		categoryDao.create(category);
		assertTrue(category!=null && category.getCategoryId()>0);
	}

	@Test
	public void testUpdateCategory() {
		
		Category cat = new Category();
		cat.setCategoryId(11);
		cat.setName("Core-Java");
		
		Category cRef = categoryDao.update(cat);
		assertEquals(cat.getName(),cRef.getName());
		
	}

	@Test
	public void testGet() {
		Category cat =categoryDao.get(11);
		assertNotNull(cat);
	}

	@Test
	public void testDeleteObject() {
		categoryDao.delete(12);
		Category cat =categoryDao.get(12);
		assertNotNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category>listCategory= categoryDao.listAll();
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		List<Category> listUsers= categoryDao.listAll();
		long count = listUsers.size();
		long expected = count;
		long actual=categoryDao.Count();
		assertEquals(expected,actual);
	}
	
	@AfterClass
	public static void tearDownClass() {
		BaseDaoTest.tearDownClass();
	}

}
