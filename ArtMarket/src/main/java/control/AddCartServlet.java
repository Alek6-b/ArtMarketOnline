package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartItem;
import model.ProductHandler;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<CartItem> cart = 	(ArrayList<CartItem>) request.getSession().getAttribute("cart");
		try {
			ProductHandler p = new ProductHandler();
			int productId = Integer.parseInt(request.getParameter("selectProduct"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			cart.add(new CartItem(p.getProduct(productId),quantity));
			response.sendRedirect("/ArtMarket/Cart.jsp");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
