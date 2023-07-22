package model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "emptyTagFilter", urlPatterns="/Gallery.jsp")

public class EmptyTagFilter implements Filter  {

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) arg1;
		if (arg0.getParameter("tag")==null)
			res.sendRedirect("/ArtMarket/Home.jsp");
		else
			arg2.doFilter(arg0, arg1);
	}
	
}
