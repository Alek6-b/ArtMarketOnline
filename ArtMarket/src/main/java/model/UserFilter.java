package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "userFilter", urlPatterns="/*")
public class UserFilter implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		
		Boolean admin = (Boolean) req.getSession().getAttribute("admin");
		String path = req.getServletPath();
		if (path.contains("/UserArea/") && admin==null) {
			res.sendRedirect("/ArtMarket/Login.jsp");
		}
		if (path.contains("/AdminArea/")&&(!admin||admin==null))
			res.sendRedirect("/ArtMarket/");
		
		arg2.doFilter(arg0, arg1);
	}
	
}
