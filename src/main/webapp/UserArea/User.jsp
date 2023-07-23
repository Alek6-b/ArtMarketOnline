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
	Benvenuto <%= user %>!
	<br>
	<% if ((boolean) request.getSession().getAttribute("admin")){%>
	<a id="admin" href="/ArtMarket/UserArea/AdminArea/Admin.jsp">Go to Admin Page</a>
	<%	
	}
	%>
<br>
	<a id="visualizza" href="/ArtMarket/UserArea/UserOrders.jsp">Vizualizza Ordini</a>	
		<%@include file="../Footer.jsp" %>
	
</body>
</html>