<%@page import="org.eclipse.jdt.internal.compiler.ast.ThisReference"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"     import="model.CartItem,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Art Market Online</title>
<link rel="stylesheet" href="/ArtMarket/styles/mainStyle.css" type="text/css">
<script src="https://kit.fontawesome.com/b99c5b4502.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">

</head>
<body>
<%
  	ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
  	if (cart==null)
  		cart = new ArrayList<CartItem>();
  		request.getSession().setAttribute("cart", cart);
  	%>


<header>
<div id="header">
		<nav>
			<ul>
				<li><img src="/ArtMarket/images/logoTsw0.png" alt="Homepage"></li>
				<li class="head">
				<% String user = (String) request.getSession().getAttribute("user");
					if (user==null) {
				%>
				<a href="/ArtMarket/Login.jsp">Accedi</a></li>
				<li><a href="/ArtMarket/Register.jsp">Registrati</a></li>
				<%} else {%>
				<li>Hi <a href="/ArtMarket/UserArea/User.jsp"><%= user %></a>!</li>
				<li><li>
				<%}%>
				<li><a href="/ArtMarket/Cart.jsp"><i class="fa-solid fa-cart-shopping" style="color: #9a5ecb;"><%=cart.size() %></i></a></li>
				
			</ul>
		</nav>
		
</div>

<div class="page">
		<nav>
			<ul>
				<li><a href="/ArtMarket/Home.jsp">Home</a></li>
				<li>
				
				<div class="dropdown">
					<button class="drop">Categorie</button>
					<div class="dropdown-content">
						<a href="/ArtMarket/Gallery.jsp?tag=Fantasy">Fantasy</a>
						<a href="/ArtMarket/Gallery.jsp?tag=Nature">Nature</a>
						<a href="/ArtMarket/Gallery.jsp?tag=Animals">Animals</a>
						<a href="/ArtMarket/Gallery.jsp?tag=World">World</a>
						<a href="/ArtMarket/Gallery.jsp?tag=PopCulture">Pop Culture</a>
					</div>
				</div>
				
				</li>
				<li><a href="#">Chi siamo</a></li>
				<li><form>
  <input class="search" type="search" placeholder="Cerca">
  <i class="fa-solid fa-magnifying-glass" style="color: #805ecb;"></i>
</form>
</li>
			</ul>
		</nav>
		
				
		
</div>
</header>
<br>
</body>
</html>