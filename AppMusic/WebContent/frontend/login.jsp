<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test File</title>
</head>
<body>
	<%@include file="/frontend/header.jsp" %>
	
	<div  align="center">
		<h2>Login Form :</h2>
		<form action="" method="post">
			Email:<input type="text" size="10">
			Password:<input type="password" size="10">
			<input type="submit" value="Login">
		</form>
	</div>
	
	<%@include file="/frontend/footer.jsp" %>

</body>
</html>