<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.PieceHandler,model.Piece"%>

<jsp:useBean id="pieceHandler" class="model.PieceHandler"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
</head>
<body>
	<%@include file="/Header.jsp" %>
	<%
		String idString = request.getParameter("piece");
		if (idString == null){
			response.sendRedirect("/ArtMarket/Home.jsp");
		}
		int pieceId = Integer.parseInt(idString);
		Piece p = pieceHandler.getPiece(pieceId);
	%>
	<div id="operaSelezionata">
	<img alt="" src=<%= p.getImageSource() %>>
	</div>
	
	
	<%@include file="/Footer.jsp" %>
	
</body>
</html>