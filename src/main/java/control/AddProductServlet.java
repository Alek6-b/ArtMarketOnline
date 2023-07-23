package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import model.Product;
import model.ProductHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PieceHandler;
/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String format = request.getParameter("format");
		String piece = request.getParameter("piece");
		String price = request.getParameter("price");
		try {
			PieceHandler pp= new PieceHandler();
			ProductHandler p = new ProductHandler();
			p.makeProduct(new Product(pp.getPiece(Integer.parseInt(piece)),format,BigDecimal.valueOf(Integer.parseInt(price))));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
