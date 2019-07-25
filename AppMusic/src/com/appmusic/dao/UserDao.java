package com.appmusic.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.appmusic.entity.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public Users create(Users e) {
		// TODO Auto-generated method stub
		return super.create(e);
	}
	
	public Users fingByEmail(String email) {
		List<Users> listUser=super.findWithNameQuery("Users.findEmail","email",email);
		if(listUser!=null && listUser.size()==1) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Override
	public Users update(Users e) {
		// TODO Auto-generated method stub
		return super.update(e);
	}

	@Override
	public Users get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Users.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);
		
	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Users.findAll");
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return super.countWithName("Users.countAll");
	}
	
	
	
	

}
