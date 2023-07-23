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

	<a id="immagini" href="/ArtMarket/UserArea/UserImages.jsp">Visualizza Opere</a><br>
	<a id="ordini" href="/ArtMarket/UserArea/UserOrders.jsp">Vizualizza Ordini</a>	
		<%@include file="../Footer.jsp" %>
	
</body>
</html>