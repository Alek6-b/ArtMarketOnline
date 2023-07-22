<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.GalleryHandler,model.Piece,java.util.ArrayList"%>
<!DOCTYPE html>

<jsp:useBean id="galleryHandler" class="model.GalleryHandler"></jsp:useBean>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<div> Test
	<%
		String tag = request.getParameter("tag");
	%>
		<h1><%= tag %></h1>
	<%
		ArrayList<Piece> pieces = galleryHandler.getGallery("tag");%>
		<%
		for (Piece i : pieces){
			%>
			<img alt=<%= i.getTitle() %> src=<%= i.getImageSource() %>>
			<%
		}
	%>
	</div>
	
	<%@include file="/Footer.jsp" %>
	
</body>
</html>