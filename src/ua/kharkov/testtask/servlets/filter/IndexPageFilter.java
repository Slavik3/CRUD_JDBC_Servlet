package ua.kharkov.testtask.servlets.filter;
import java.io.IOException;
import java.util.List;

import javax.servlet.*;

import ua.kharkov.testtask.dao.UserDAO;
import ua.kharkov.testtask.dao.entity.User;

/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
public class IndexPageFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter");

	    UserDAO u = new UserDAO();
		List<User> userList = u.select();
		System.out.println("userList "+userList);
		req.setAttribute("usersBeanList", userList);		
		
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	          
	    chain.doFilter(req, resp);
	}	
	
	@Override
	public void destroy() {
	}
}
