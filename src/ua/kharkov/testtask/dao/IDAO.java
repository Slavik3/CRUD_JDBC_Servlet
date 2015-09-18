package ua.kharkov.testtask.dao;

import java.util.List;

import ua.kharkov.testtask.dao.entity.User;

/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
public interface IDAO {
	
	public void insert(User user);
	
	public User getUserById(int id);

	public void update(User user);

	public void delete(int id);	
	
	public List<User> select();
	
}
