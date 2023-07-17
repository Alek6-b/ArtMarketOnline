<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.OrderHandler,model.Order,java.util.ArrayList,java.io.IOException"%>
<jsp:useBean id="orderHandler" class="model.OrderHandler"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<table>
	<tr><td>Codice</td><td>Data</td><td>Prezzo</td></tr>
	<%
		OrderHandler o = new OrderHandler();
		ArrayList<Order> result = o.getUserOrders((String) getServletContext().getAttribute("user"));
		result.sor
		for(Order i : result){
			try{%>
			<tr><td><%= i.getId() %></td><td><%= i.getDate() %></td><td><%= i.getPrice() %></td></tr>
			<%} catch (final IOException e){
				e.getMessage();
			}
		};
		 %>
	</table>
</body>
</html>