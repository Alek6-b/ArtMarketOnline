<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.OrderHandler,model.Order,java.util.ArrayList,java.io.IOException"%>
<jsp:useBean id="orderHandler" class="model.OrderHandler"></jsp:useBean>

<!DOCTYPE html>
<html>
<head><script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<table>
	<caption>Orders</caption>
	<tr><th>Codice</th><th>Data</th><th>Prezzo</th><th>Descrizione</th></tr>
	<%
		ArrayList<Order> result = (ArrayList<Order>) orderHandler.getUserOrders((String) request.getSession().getAttribute("user"));
		for(Order i : result){
			try{%>
			<tr><td><%= i.getId() %></td><td><%= i.getDate() %></td><td><%= i.getPrice() %></td><td><%= i.getDescription() %></td></tr>
			<%} catch (final IOException e){
				e.getMessage();
			}
		};
		 %>
	</table>
		<%@include file="../Footer.jsp" %>
	
</body>
</html>