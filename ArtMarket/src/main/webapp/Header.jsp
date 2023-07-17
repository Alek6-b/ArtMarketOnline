<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="SiteHeader">ArtMarketOnline</div>
<div id="UserBar">
<% String user = (String) getServletContext().getAttribute("user");
	if (user==null) {
%>
<a href="/ArtMarket/Login.jsp">Login</a> or <a href="/ArtMarket/Register.jsp">Register</a>
<%} else {%>
Hi <%= user %>!
<%}%>
</div>
<br>
</body>
</html>