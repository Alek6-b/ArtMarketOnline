package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserHandler;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		UserHandler u;
		try {
			u = new UserHandler();
			if(!u.checkUser(user)) {
				u.registerUser(user, password);
				getServletContext().setAttribute("user", user);
				response.sendRedirect("Home.jsp");
			}
			else {
				request.setAttribute("Error","Username Taken");
				getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			}

}
