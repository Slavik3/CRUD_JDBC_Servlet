package ua.kharkov.testtask.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kharkov.testtask.dao.UserDAO;
import ua.kharkov.testtask.dao.entity.User;

import java.sql.Date;
import java.util.List;

/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet { 	
	
	private static final long serialVersionUID = -3334938546540034091L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = String.valueOf(request.getParameter("action"));
		UserDAO userDAO = new UserDAO();
		if(commandName.equals("Save")) {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userDAO.getUserById(id);
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			int amountOfMoney = Integer.valueOf(request.getParameter("amountOfMoney"));
			String address = request.getParameter("address");
			user.setName(name);
			user.setSurname(surname);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setAmountOfMoney(amountOfMoney);
			user.setAddress(address);
			userDAO.update(user);
			String message = "User was updated";
			request.setAttribute("message", message);
		}
		
		if(commandName.equals("Add")) {
			User user = new User();
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			int amountOfMoney = Integer.valueOf(request.getParameter("amountOfMoney"));
			String address = request.getParameter("address");
			user.setName(name);
			user.setSurname(surname);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setAmountOfMoney(amountOfMoney);
			user.setAddress(address);
			userDAO.insert(user);
			String message = "User was added";
			request.setAttribute("message", message);
		}
		
		if(commandName.equals("Cancel")) {
			System.out.println("Cancel");
			String message = "Canceled";
			request.setAttribute("message", message);
		}
		
		List<User> userList = userDAO.select();			
		request.setAttribute("usersBeanList", userList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
 
}
