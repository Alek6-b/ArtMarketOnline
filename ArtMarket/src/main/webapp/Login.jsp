<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/Header.jsp" %>
<form id="login" action="LoginServlet" method="post">
	<fieldset>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" required>
		<br>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" required>
		<br>
		<input type="submit" value = "Login">
	</fieldset>
</form>
<div id="errorBox">
	<% String error = (String)request.getAttribute("Error");
		if (!(error==null)){
	%><%=error %>
	<% } %>
</div>

	<%@include file="/Footer.jsp" %>

</body>
</html>