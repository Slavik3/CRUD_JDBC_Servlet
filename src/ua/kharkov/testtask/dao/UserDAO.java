package ua.kharkov.testtask.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.kharkov.testtask.dao.connection.DBConnection;
import ua.kharkov.testtask.dao.entity.User;


/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
public class UserDAO implements IDAO {

	private static String SQL_INSERT = "INSERT INTO users (name, surname, email, birthday, amount_of_money, address, id) VALUE (?, ?, ?, ?, ?, ?, ?); ";
	private static String SQL_SELECT = "SELECT * FROM users;";
	private static String SQL_SELECT_USER_BY_ID = "SELECT * FROM users where id = ?;";
	private static String SQL_DELETE_BY_ID = "delete from users where id = ?;";
	private static String SQL_UPDATE = "UPDATE users SET name=?, surname=?, email=?, birthday=?, amount_of_money=?, address=? WHERE id=?;";
	
	@Override
	public void insert(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getEmail());
			ps.setDate(4, user.getBirthday());
			ps.setInt(5, user.getAmountOfMoney()*100);
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getId());
			ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
	}
	
	@Override
	public User getUserById(int id) {
		User user = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_USER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = extractUser(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return user;
	}

	@Override
	public void update(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(SQL_UPDATE);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getEmail());
			ps.setDate(4, user.getBirthday());
			ps.setInt(5, user.getAmountOfMoney()*100);
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(con);
		}

	}
	
	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SQL_DELETE_BY_ID);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
	}

	@Override
	public List<User> select() {
		Connection con = null;
		List<User> list = new ArrayList<User>();
		try {
			con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(SQL_SELECT);
			while (result.next()) {
				User user = extractUser(result);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return list;
	}

	private void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setEmail(rs.getString("email"));
		user.setBirthday(rs.getDate("birthday"));
		user.setAmountOfMoney(rs.getInt("amount_of_money")/100);
		user.setAddress(rs.getString("address"));
		return user;
	}
	
	
}