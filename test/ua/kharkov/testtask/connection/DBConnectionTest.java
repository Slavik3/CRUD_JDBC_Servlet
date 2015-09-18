package ua.kharkov.testtask.connection;

import static org.junit.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import ua.kharkov.testtask.dao.connection.DBConnection;

public class DBConnectionTest {

	@Test
	public void testGetConnection() {
		Connection c=DBConnection.getConnection();
		
		try {
			assertFalse(c.isClosed());
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	

}
