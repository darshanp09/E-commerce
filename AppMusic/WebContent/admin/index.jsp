<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore Administration</title>
</head>
<body>
	<%@include file="/admin/header.jsp" %>
	
	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>
	<div align="center">
		<hr width="60%"/>
		<h2>Quick Actions : </h2>
		<b>
		<a href="create_book">New Book</a> &nbsp;
		<a href="create_user">New User</a> &nbsp;
		<a href="create_category">New Category</a> &nbsp;
		<a href="create_customer">New Customer</a> &nbsp;
		</b>
	</div>	
	<div align="center">
		<hr width="60%"/>
		<h2>Recent Sales :</h2>
	</div>
	
	<div align="center">
		<hr width="60%"/>
		<h2>Recent Reviews :</h2>
	</div>
	
	<div align="center">
		<hr width="60%"/>
		<h2>Statistics :</h2>
	</div>
	<%@include file="/admin/footer.jsp" %>
</body>
</html>