package ua.kharkov.testtask.dao.entity;

import java.sql.Date;

/**
 * 
 * @author Vyacheslav Kozlov
 *
 */
public class User {
	private int id;
	private String name;
	private String surname;
	private String email;
	private Date birthday;	
	private int amountOfMoney;	
	private String address;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(int amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();		
	}

	public User(int id, String name, String surname, String email,
			Date birthday, int amountOfMoney, String address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthday = birthday;
		this.amountOfMoney = amountOfMoney;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", birthday=" + birthday
				+ ", amountOfMoney=" + amountOfMoney + ", address=" + address
				+ "]";
	}


}
