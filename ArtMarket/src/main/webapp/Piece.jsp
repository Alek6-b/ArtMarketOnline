<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.PieceHandler,model.Piece,model.ProductHandler,model.Product,java.util.ArrayList"%>

<jsp:useBean id="pieceHandler" class="model.PieceHandler"></jsp:useBean>
<jsp:useBean id="piece" class="model.Piece"></jsp:useBean>
<jsp:useBean id="productHandler" class="model.ProductHandler"></jsp:useBean>
<jsp:useBean id="product" class="model.Product"></jsp:useBean>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ArtMarketOnline</title>
<script type="text/javascript" src="scripts/PieceInfoDisplayer.js"></script>

</head>
<body>
	<%@include file="/Header.jsp"%>
	<%
	String idString = request.getParameter("piece");
	int pieceId = Integer.parseInt(idString);
	piece = pieceHandler.getPiece(pieceId);
	%>
	<h1 id="titoloOpera"><%=piece.getTitle()%></h1>
	<div class="row">
		<div class="mainColumn">
			<div id="operaSelezionata">
				<img alt=<%=piece.getTitle()%> src=<%=piece.getImageSource()%>>
			</div>
			<div>

				<form action="AddCartServlet" method="post">
					<%
					ArrayList<Product> prods = (ArrayList<Product>) productHandler.getPieceProducts(pieceId);
					%>
					<select name="selectProduct" id="selectProduct"
						onchange="func(this.value)">
						<%
						for (Product i : prods) {
						%>
						<option value=<%=""+i.getId()%>><%=i.getFormat()%></option>
						<%
						}
						%>
					</select> <input type="number" min=1 value=1 id="quantity" name="quantity"> <input
						type="submit" value="Aggiungi">
				</form>
			</div>
			<div id="productDisplay"></div>

		</div>

	</div>
	<%@include file="/Footer.jsp"%>
</body>
</html>