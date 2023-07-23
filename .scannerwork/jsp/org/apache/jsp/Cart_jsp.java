/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2023-07-23 09:58:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ProductHandler;
import java.math.BigDecimal;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import model.CartItem;
import java.util.ArrayList;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/Header.jsp", Long.valueOf(1690057452412L));
    _jspx_dependants.put("/Footer.jsp", Long.valueOf(1689705584566L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.math.BigDecimal");
    _jspx_imports_classes.add("model.CartItem");
    _jspx_imports_classes.add("model.ProductHandler");
    _jspx_imports_classes.add("org.eclipse.jdt.internal.compiler.ast.ThisReference");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n<title>ArtMarketOnline</title>\r\n</head>\r\n<body>\r\n	");
      out.write("\r\n\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<title>Art Market Online</title>\r\n<link rel=\"stylesheet\" href=\"/ArtMarket/styles/mainStyle.css\" type=\"text/css\">\r\n<script src=\"https://kit.fontawesome.com/b99c5b4502.js\" crossorigin=\"anonymous\"></script>\r\n<meta charset=\"ISO-8859-1\">\r\n\r\n</head>\r\n<body>\r\n");

  	ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
  	if (cart==null)
  		cart = new ArrayList<CartItem>();
  		request.getSession().setAttribute("cart", cart);
  	
      out.write("\r\n\r\n\r\n<header>\r\n<div id=\"header\">\r\n		<nav>\r\n			<ul>\r\n				<li><img src=\"/ArtMarket/images/logoTsw0.png\" alt=\"Homepage\"></li>\r\n				<li class=\"head\">\r\n				");
 String user = (String) request.getSession().getAttribute("user");
					if (user==null) {
				
      out.write("\r\n				<a href=\"/ArtMarket/Login.jsp\">Accedi</a></li>\r\n				<li><a href=\"/ArtMarket/Register.jsp\">Registrati</a></li>\r\n				");
} else {
      out.write("\r\n				<li>Hi <a href=\"/ArtMarket/UserArea/User.jsp\">");
      out.print( user );
      out.write("</a>!</li>\r\n				<li><a href=\"LogoutServlet\">Logout</a><li>\r\n				");
}
      out.write("\r\n				<li><a href=\"/ArtMarket/Cart.jsp\"><i class=\"fa-solid fa-cart-shopping\" style=\"color: #9a5ecb;\">");
      out.print(cart.size() );
      out.write("</i></a></li>\r\n				\r\n			</ul>\r\n		</nav>\r\n		\r\n</div>\r\n\r\n<div class=\"page\">\r\n		<nav>\r\n			<ul>\r\n				<li><a href=\"/ArtMarket/Home.jsp\">Home</a></li>\r\n				<li>\r\n				\r\n				<div class=\"dropdown\">\r\n					<button class=\"drop\">Categorie</button>\r\n					<div class=\"dropdown-content\">\r\n						<a href=\"/ArtMarket/Gallery.jsp?tag=Fantasy\">Fantasy</a>\r\n						<a href=\"/ArtMarket/Gallery.jsp?tag=Nature\">Nature</a>\r\n						<a href=\"/ArtMarket/Gallery.jsp?tag=Animals\">Animals</a>\r\n						<a href=\"/ArtMarket/Gallery.jsp?tag=World\">World</a>\r\n						<a href=\"/ArtMarket/Gallery.jsp?tag=PopCulture\">Pop Culture</a>\r\n					</div>\r\n				</div>\r\n				\r\n				</li>\r\n				<li><a href=\"#\">Chi siamo</a></li>\r\n				<li><form>\r\n  <input class=\"search\" type=\"search\" placeholder=\"Cerca\">\r\n  <i class=\"fa-solid fa-magnifying-glass\" style=\"color: #805ecb;\"></i>\r\n</form>\r\n</li>\r\n			</ul>\r\n		</nav>\r\n		\r\n				\r\n		\r\n</div>\r\n</header>\r\n<br>\r\n</body>\r\n</html>");
      out.write("\r\n	<table id=\"Prodotti\">\r\n	<caption>Prodotti</caption>\r\n	<tr><th>Immagine</th><th>Nome</th><th>Quantità</th><th>Prezzo</th></tr>\r\n	\r\n");

	for(CartItem i : cart){
	
      out.write("	\r\n	<tr>\r\n	<td><img src=");
      out.print( i.getProduct().getPiece().getImageSource() );
      out.write(" alt=");
      out.print( i.getProduct().getPiece().getTitle() );
      out.write("><img>\r\n	<td>");
      out.print( i.getProduct().getPiece().getTitle()+" "+i.getProduct().getFormat() );
      out.write("</td>\r\n	<td>");
      out.print( i.getQuantity() );
      out.write("</td>\r\n	<td>");
      out.print( i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getQuantity())) );
      out.write("\r\n	</tr>\r\n	");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n<title>Insert title here</title>\r\n</head>\r\n<body>\r\n<footer>©2023 Art Market Online\r\n<p>\r\n<i class=\"fa-brands fa-facebook\"></i>\r\n<i class=\"fa-brands fa-twitter\"></i>\r\n<i class=\"fa-brands fa-instagram\"></i>\r\n<p>\r\n</footer>	\r\n</body>\r\n</html>");
      out.write("\r\n	</table>\r\n	<a href=\"/ArtMarket/OrderMakerServlet\">Conferma Ordine</a>\r\n");
      out.write("\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n<title>Insert title here</title>\r\n</head>\r\n<body>\r\n<footer>©2023 Art Market Online\r\n<p>\r\n<i class=\"fa-brands fa-facebook\"></i>\r\n<i class=\"fa-brands fa-twitter\"></i>\r\n<i class=\"fa-brands fa-instagram\"></i>\r\n<p>\r\n</footer>	\r\n</body>\r\n</html>");
      out.write("\r\n</body>\r\n</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
