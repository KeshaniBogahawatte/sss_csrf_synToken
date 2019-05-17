<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="Login_controller">
		<label>Username : </label><input type="text" name="username" /> 
		<label>Password : </label><input type="password" name="password"/>
		<!--  <c:if test="${not empty sessionScope.invalidCredentials}">
			<div id="message" style="color:red;">Incorrect username & password!</div>
		</c:if> -->
		<input type="submit" value="Login">
</form>
</center>

</body>
</html>