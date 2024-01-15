package com.MongoDb.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDetails")
public class UserBean {
	@Id
	private int userId;
	private String name;
	private String address;
	private long number;

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(int userId, String name, String address, long number) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.number = number;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", name=" + name + ", address=" + address + ", number=" + number + "]";
	}

}
