package ua.kharkov.testtask.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ua.kharkov.testtask.dao.UserDAO;
import ua.kharkov.testtask.dao.entity.User;

public class UserDAOTest {

	@Test
	public void testAdd() {
		UserDAO userDAO = new UserDAO();
		int lastId = userDAO.select().get(userDAO.select().size() - 1).getId();
		int id = lastId + 1;
		User user = new User();
		user.setId(id);
		user.setName("Alan");
		user.setSurname("Wilson");
		user.setEmail("wilson@gmail.com");
		user.setBirthday(java.sql.Date.valueOf("2000-09-04"));
		user.setAmountOfMoney(1000);
		user.setAddress("1009 11th St NW Washington, DC 20001");
		UserDAO u = new UserDAO();
		u.insert(user);
		userDAO.getUserById(id);
		User user2 = u.getUserById(id);
		assertEquals("Alan", user2.getName());
		assertEquals("Wilson", user2.getSurname());
		assertEquals("wilson@gmail.com", user2.getEmail());
		assertEquals("2000-09-04", user2.getBirthday().toString());
		assertEquals(1000, user2.getAmountOfMoney());
		assertEquals("1009 11th St NW Washington, DC 20001", user2.getAddress());
	}

	@Test
	public void testAddNegative() {
		UserDAO userDAO = new UserDAO();
		int lastId = userDAO.select().get(userDAO.select().size() - 1).getId();
		int id = lastId;
		User user = new User();
		user.setId(id);
		user.setName("Alan");
		user.setSurname("Wilson");
		user.setEmail("wilson@gmail.com");
		user.setBirthday(java.sql.Date.valueOf("2000-09-04"));
		user.setAmountOfMoney(100000);
		user.setAddress("1009 11th St NW Washington, DC 20001");
		UserDAO u = new UserDAO();
		u.insert(user);

	}
	
	@Test
	public void testDel() {
		System.out.println("start testDel");
		UserDAO userDAO = new UserDAO();
		int lastId = userDAO.select().get(userDAO.select().size() - 1).getId();
		System.out.println("lastId " + lastId);
		userDAO.delete(lastId);
		int lastIdAfterDelete = userDAO.select().get(userDAO.select().size() - 1).getId();
		assertEquals(lastId-1, lastIdAfterDelete);
	}
	
	@Test
	public void testUpdate() {
		UserDAO userDAO = new UserDAO();
		//get last record
		int id = userDAO.select().get(userDAO.select().size() - 1).getId();		
		String name= userDAO.select().get(userDAO.select().size() - 1).getName();
		String surname= userDAO.select().get(userDAO.select().size() - 1).getSurname();
		Date birthday = userDAO.select().get(userDAO.select().size() - 1).getBirthday();	
		int amountOfMoney = userDAO.select().get(userDAO.select().size() - 1).getAmountOfMoney();	
		String address = userDAO.select().get(userDAO.select().size() - 1).getAddress();			
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setSurname(surname);
		user.setEmail("mymail@gmail.com");
		user.setBirthday(birthday);
		user.setAmountOfMoney(amountOfMoney);
		user.setAddress(address);		
		userDAO.update(user);
		int lastId = userDAO.select().get(userDAO.select().size() - 1).getId();
		User userAfterUpdate = userDAO.getUserById(lastId);
		assertEquals("mymail@gmail.com", userAfterUpdate.getEmail());
	}	
	
	
	@Test
	public void testUpdateNeg() {
		UserDAO userDAO = new UserDAO();
		//get last record
		int id = userDAO.select().get(userDAO.select().size() - 1).getId();		
		User user = new User();
		user.setId(id);
		userDAO.update(user);
	}
		
}
