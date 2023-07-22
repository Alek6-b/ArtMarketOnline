<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.OrderHandler,model.Order"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="o" class="model.OrderHandler"></jsp:useBean>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../Header.jsp"%>

	<form action="Admin.jsp">
		<fieldset>
			<legend>Controlla Ordini</legend>

			<label for="username">Username</label> <input type="text"
				id="username" name="username" required> <br> <input
				type="submit" value="Controlla">
		</fieldset>
	</form>
	<%
	String check = request.getParameter("username");
	if (check != null) {
	%>
	<table>
		<caption>Orders</caption>
		<tr>
			<th>Codice</th>
			<th>Data</th>
			<th>Prezzo</th>
			<th>Descrizione</th>
		</tr>
		<%
		ArrayList<Order> list = (ArrayList<Order>) o.getUserOrders(check);
		for (Order i : list) {
		%>
		<tr>
			<td><%=i.getId()%></td>
			<td><%=i.getDate()%></td>
			<td><%=i.getPrice()%></td>
			<td><%=i.getDescription()%></td>
		</tr>

		<%
		}
		%>
	</table>
	<%
	}
	%>
	<%@include file="../../Footer.jsp"%>

</body>
</html>