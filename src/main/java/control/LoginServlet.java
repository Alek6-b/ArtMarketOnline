package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserHandler;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		UserHandler u;
		try {
			u = new UserHandler();
			if (u.verifyUser(user, password).booleanValue()) {
				HttpSession ss = request.getSession(true);
				ss.setAttribute("user", user);
				ss.setAttribute("admin", u.isAdmin(user));
				response.sendRedirect("UserArea/User.jsp");
			}
			else {
				request.setAttribute("Error","Login Failed");
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
