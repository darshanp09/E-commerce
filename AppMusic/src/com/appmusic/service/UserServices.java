package com.appmusic.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appmusic.dao.UserDao;
import com.appmusic.entity.Users;

public class UserServices {
	
	private UserDao userDao;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		entityManagerFactory = Persistence.createEntityManagerFactory("AppMusic");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDao(entityManager);
		this.request=request;
		this.response=response;
	}
	
	
	public  void listUsers() throws ServletException, IOException {
		listUsers(null);
	}
	
	
	public  void listUsers(String message) throws ServletException, IOException {
		
		List<Users> listUsers=userDao.listAll();
		if(message !=null) {
		request.setAttribute("message", message);
		}
		request.setAttribute("listUser", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list_users.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		Users existUser = userDao.fingByEmail(email);
		if(existUser!=null) {
			String message = "User with the "+ email +" Already Exists !";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}else {
			Users users = new Users();
			users.setEmail(email);
			users.setFullName(fullName);
			users.setPassword(password);
			userDao.create(users);
			listUsers("New user has been created.");
		}
	}


	public void editUser() throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user=userDao.get(userId);
		request.setAttribute("user",user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		dispatcher.forward(request, response);
		
		
		
	}


	public void updateUser() throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		System.out.println(email+" - "+fullName+" - "+ password);
		
		Users userById = userDao.get(userId);
		Users userByEmail = userDao.fingByEmail(email);
		
		if(userByEmail!= null && (userByEmail.getUserId()!=userById.getUserId())) {
			String message = "User with the "+ email +" Already Exists !";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			
		}else {
			Users users = new Users(userId,email,password,fullName);
			userDao.update(users);
			listUsers("User has been updated !");
			
		}
			
			
		
	}


	public void deleteUser() throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("id"));
		
		userDao.delete(userId);
		
		listUsers("User has been delete successfully !");
		
	}

}
