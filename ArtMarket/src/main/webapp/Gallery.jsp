<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.GalleryHandler,model.Piece,java.util.ArrayList"%>
<!DOCTYPE html>

<jsp:useBean id="galleryHandler" class="model.GalleryHandler"></jsp:useBean>

<html>
<head>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<div class="gallery">
	<%
		String tag = request.getParameter("tag");
	%>
		<h1><%= tag %></h1>
	<%
		ArrayList<Piece> pieces = (ArrayList<Piece>) galleryHandler.getGallery(tag);%>
		<h2>		<%= pieces.size() %> pezzi.
		</h2>
		<%
		for (Piece i : pieces){
			%>
			<a href="/ArtMarket/Piece.jsp?piece=<%= i.getId()  %>"><img alt=<%= i.getTitle() %> src=<%= i.getImageSource() %>></a>
			<%
		}
	%>
	</div>
	
	<%@include file="/Footer.jsp" %>
	
</body>
</html>