package ua.kharkov.testtask.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kharkov.testtask.dao.UserDAO;
import ua.kharkov.testtask.dao.entity.User;



/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
@WebServlet("/RefreshEditDelete")
public class RefreshEditDelete extends HttpServlet {
	
	private static final long serialVersionUID = -9146245048252269770L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = String.valueOf(request.getParameter("action"));
		UserDAO userDAO = new UserDAO();
		
		if(commandName.equals("Refresh")) {
			List<User> userList = userDAO.select();			
			request.setAttribute("usersBeanList", userList);			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(commandName.equals("Delete")) {
			String[] userId = (request.getParameterValues("userId"));
			if(userId != null){
				for(String idS : userId) {
					int id = Integer.parseInt(idS);		
					userDAO.delete(id);				
				}
				String message = "Row was deleted";
				request.setAttribute("message", message);
			} else {
				String message = "Please select row to delete";
				request.setAttribute("message", message);
			}
			List<User> userList = userDAO.select();			
			request.setAttribute("usersBeanList", userList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(commandName.equals("Edit")) {
			String[] userIds = request.getParameterValues("userId");
			
			if(userIds==null){
				String message = "Not any row is selected ";
				request.setAttribute("message", message);
				List<User> userList = userDAO.select();			
				request.setAttribute("usersBeanList", userList);
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
			
			if(userIds!=null){
				if(userIds.length>1){
					String message = "Please select just one row to be edited";
					request.setAttribute("message", message);
					List<User> userList = userDAO.select();			
					request.setAttribute("usersBeanList", userList);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}	
				if(userIds.length == 1){
					int userId = Integer.valueOf(request.getParameter("userId"));
					User user = userDAO.getUserById(userId);
					request.setAttribute("user", user);
					request.getRequestDispatcher("edit.jsp").forward(request, response);
				}
			}			
		}				
	
	}

}
