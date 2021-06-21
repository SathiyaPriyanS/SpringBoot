package com.spring.springbootdemo.service;

import java.util.List;

import com.springspringbootdemo.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserid(Integer userid);
	void createUser(Integer userid, String username);
	void updateUser(Integer userid, String username);
	void deleteUser(Integer userid);
}