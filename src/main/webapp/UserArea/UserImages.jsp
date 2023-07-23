<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,model.Piece"%>
<!DOCTYPE html>

<html>
<head>
<jsp:useBean id="PieceHandler" class="model.PieceHandler"></jsp:useBean>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/Header.jsp" %>


<h1>Le tue Opere</h1>
<div>
	<% 	
	ArrayList<Piece> p = (ArrayList<Piece>) PieceHandler.getUserPieces(user); 
	for(Piece i:p){
%>		<a href="/ArtMarket/Piece.jsp?piece=<%= i.getId()  %>"><img alt=<%= i.getTitle() %> src=<%= i.getImageSource() %>></a><%
	}
		%>
		<%@include file="../Footer.jsp" %>

</div>
</body>
</html>