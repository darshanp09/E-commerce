package com.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.appmusic.entity.Category;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category> {

	public CategoryDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	
	public Category create(Category e) {
		return super.create(e);
	}
	
	public Category update(Category e) {
		// TODO Auto-generated method stub
		return super.update(e);
	}

	@Override
	public Category get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Category.class, id);
		
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNameQuery("Category.findAll");
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return super.countWithName("Category.countAll");
	}

}
