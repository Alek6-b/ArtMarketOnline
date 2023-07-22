<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.ProductHandler,java.math.BigDecimal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<table id="Prodotti">
	<caption>Prodotti</caption>
	<tr><th>Immagine</th><th>Nome</th><th>Quantità</th><th>Prezzo</th></tr>
	
<%
	for(CartItem i : cart){
	%>	
	<tr>
	<td><img src=<%= i.getProduct().getPiece().getImageSource() %> alt=<%= i.getProduct().getPiece().getTitle() %>><img>
	<td><%= i.getProduct().getPiece().getTitle()+" "+i.getProduct().getFormat() %></td>
	<td><%= i.getQuantity() %></td>
	<td><%= i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getQuantity())) %>
	</tr>
	<%} %>
	<%@include file="/Footer.jsp" %>
	</table>

</body>
</html>