<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="scripts/RegisterValidator.js"></script>
</head>
<body>
<%@include file="/Header.jsp" %>

<form class="register" action="RegisterServlet" method="post" id="register" name="register" onsubmit="return validate()">
	<fieldset>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" required>
		<br>
		<label for="password">Password</label>
		<input id="pass" type="password" id="password" name="password" required>
		<br>
		<label for="confirmPassword">Confirm Password</label>
		<input type="password" id="confirmPassword" name="confirmPassword" required>
		<br>
		<input type="submit" value = "Register">
	</fieldset>
	<div id="errorBox">
	<%
		String error = (String)request.getAttribute("Error");
		if (!(error==null)){
	%><%=error %>
	<%} %></div>
</form>
	<%@include file="/Footer.jsp" %>

</body>
</html>