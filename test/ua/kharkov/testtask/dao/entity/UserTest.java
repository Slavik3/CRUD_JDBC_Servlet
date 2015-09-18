package ua.kharkov.testtask.dao.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.kharkov.testtask.dao.UserDAO;
import ua.kharkov.testtask.dao.entity.User;



public class UserTest {
	
	@Test
	public void testUser() {
		UserDAO userDAO = new UserDAO();
		int lastId = userDAO.select().get(userDAO.select().size()-1).getId();
		int id =lastId+1;
		User user = new User(id, "Alex", "Bailey", "Bailey@gmail.com", java.sql.Date.valueOf("2000-08-04"), 100000, "Washington, DC 20530");
		assertEquals("User [id=" + id + ", name=Alex, surname=Bailey, email=Bailey@gmail.com, birthday=2000-08-04, amountOfMoney=100000, address=Washington, DC 20530]", user.toString());
		
	}
	
	
	

}
