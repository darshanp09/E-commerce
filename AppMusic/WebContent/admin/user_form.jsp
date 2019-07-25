<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New User</title>
</head>
<body>
	<%@include file="/admin/header.jsp" %>
	
	<div align="center">
		<c:if test="${user!=null }">
			<h2>Edit User</h2>
		</c:if>
		<c:if test="${user==null }">
			<h2>Create New User</h2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${user==null }">
			<form action="create_user" method="post" onsubmit="return validationFormInput()">
		</c:if>
		<c:if test="${user!=null }">
			<form action="update_user" method="post" onsubmit="return validationFormInput()">
			<input type="hidden"  name="userId" value="${user.userId}">
		</c:if>
		<table>
			<tr>
				<td align="right">Email : </td>
				<td align="left"><input type="text" name="email" id="email" value="${user.email }" size="20"></td>
			</tr>
			<tr>
				<td align="right">Full Name : </td>
				<td align="left"><input type="text" name="fullName" id="fullname" value = "${user.fullName }" size="20"></td>
			</tr>
			<tr>
				<td align="right">Password : </td>
				<td align="left"><input type="password" name="password" value = "${user.password }" id="password" size="20"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
					<input type="button" value="Cancel" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>
		</form>
	</div>
	<%@include file="/admin/footer.jsp" %>
</body>
<script type="text/javascript">
	function validationFormInput(){
	    var fieldEmail = document.getElementById("email");
	    var fieldName = document.getElementById("fullname");
	    var fieldPassword = document.getElementById("password");
	
	    if(fieldEmail.value.length==0){
	        alert("Email is required !")
	        fieldEmail.focus();
	        return false;
	    }
	    if(fieldName.value.length==0){
	        alert("Full Name is required !")
	        fieldEmail.focus();
	        return false;
	    }
	    if(fieldPassword.value.length==0){
	        alert("Password is required !")
	        fieldEmail.focus();
	        return false;
	    }
	    return true;
	}
</script>
</html>