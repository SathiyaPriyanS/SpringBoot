package com.springspringbootdemo.model;

public class User {
	
	Integer UserId;
	String Username;
	
	public User(Integer userId, String username) {
		super();
		UserId = userId;
		Username = username;
	}
	
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	

}
