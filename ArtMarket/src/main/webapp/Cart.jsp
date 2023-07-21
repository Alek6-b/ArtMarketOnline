<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.ProductHandler"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<table>
	<tr><th>Immagine</th><th>Nome</th><th>Quantità</th></tr>
	
<%
	cart.add(new CartItem(new ProductHandler().getProduct(1),2));
	for(CartItem i : cart){
	%>	
	<tr>
	<td><img src=<%= i.getProduct().getPiece().getImageSource() %>><img>
	<td><%= i.getProduct().getPiece().getTitle()+" "+i.getProduct().getFormat() %></td>
	<td><%= i.getQuantity() %></td>
	</tr>
	<%} %>
	<%@include file="/Footer.jsp" %>
	</table>

</body>
</html>