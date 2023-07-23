<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.OrderHandler,model.Order,model.Format,model.FormatHandler"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="o" class="model.OrderHandler"></jsp:useBean>
<jsp:useBean id="f" class="model.FormatHandler"></jsp:useBean>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../../Header.jsp"%>

	<form action="Admin.jsp" id="orderCheck">
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
	}
		%>
	</table>

	<form action="/ArtMarket/AddProductServlet" method="post" id="addProduct">
		<fieldset>
			<legend>Aggiungi Prodotto</legend>
			<label for="piece">ID Pezzo</label><input type="number" id="piece"
				name="piece"><br> <label for="format">Formato</label> <select name="format" id="format">
				<%
				ArrayList<Format> formats = (ArrayList<Format>) f.getFormats();
				for (Format i : formats) {
				%>
				<option value=<%=i.getName()%>><%=i.getName()%></option>
				<%
				}
				
				%>
			</select><br> <label for="price">Prezzo</label><input type="number"
				id="price" name="quantity"> <input type="submit"
				value="Aggiungi">
		</fieldset>
	</form>

	<%@include file="../../Footer.jsp"%>

</body>
</html>