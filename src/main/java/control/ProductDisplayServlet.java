package control;

import java.io.IOException;
import org.json.*;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Piece;
import model.Product;
import model.ProductHandler;

/**
 * Servlet implementation class ProductDisplayServlet
 */
@WebServlet("/ProductDisplayServlet")
public class ProductDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDisplayServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("application/json");
		try {
			ProductHandler h = new ProductHandler();
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = h.getProduct(id);
			PrintWriter out = response.getWriter();
			JSONObject json = new JSONObject();
			json.put("id", p.getId());
			json.put("piece", p.getPiece());
			json.put("format", p.getFormat());
			json.put("price", p.getPrice());

			out.print(json.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
