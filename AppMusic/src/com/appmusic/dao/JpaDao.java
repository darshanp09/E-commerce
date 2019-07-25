package com.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDao<E> {
	
	protected EntityManager entityManager;

	public JpaDao(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	public E create(E e) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(e);
		entityManager.flush();
		entityManager.refresh(e);
		
		entityManager.getTransaction().commit();
		
		return e;
	}
	
	public E update(E e) {
		entityManager.getTransaction().begin();
		
		entityManager.merge(e);
		
		entityManager.flush();

		
		entityManager.getTransaction().commit();
		
		return e;
	}
	
	public E find(Class<E>type,Object id) {
		E entity =entityManager.find(type, id);
		
		if(entity !=null) {
			
			entityManager.refresh(entity);
			
		}
		
		return entity;
	}
	
	public void delete( Class<E> type,Object id) {
		entityManager.getTransaction().begin();
		Object reference= entityManager.getReference(type, id);
		entityManager.remove(reference);
		
		entityManager.getTransaction().commit();
	}
	
	public List<E> findWithNameQuery(String queryName){
		
		Query query = entityManager.createNamedQuery(queryName);
		return query.getResultList();

	}
	public List<E> findWithNameQuery(String queryName,String paramName, Object paramValue){
			
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName,paramValue);
		return query.getResultList();
	
	}
	
	public long countWithName(String queryName) {
		Query query = entityManager.createNamedQuery(queryName);
		return (long) query.getSingleResult();
	}
	
	
	

}
