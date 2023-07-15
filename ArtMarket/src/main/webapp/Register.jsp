<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="/RegisterValidator.js"></script>
</head>
<body>
<form action="RegisterServlet" method="post" id="register" onsubmit="return validate()">
	<fieldset>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" required>
		<br>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" required>
		<br>
		<label for="confirmPassword">Confirm Password</label>
		<input type="password" id="confirmPassword" name="confirmPassword" required>
		<br>
		<input type="submit" value = "Login">
	</fieldset>
	<div id="errorBox"></div>
</form>

</body>
</html>