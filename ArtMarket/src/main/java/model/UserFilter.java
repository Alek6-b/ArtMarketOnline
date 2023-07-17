package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "userFilter", urlPatterns="/UserArea/*")
public class UserFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) arg1;
		String user = (String) arg0.getServletContext().getAttribute("user");
		if (user==null)
			res.sendRedirect("/ArtMarket/Login.jsp");
		arg2.doFilter(arg0, arg1);
	}
	
}
