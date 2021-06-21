package com.spring.springbootdemo.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.springspringbootdemo.model.User;
@Service
public class UserServiceImpl implements UserService {
    public List<User> users;
    
	@Override
	public List<User> getAllUsers() {
		
		return this.users;
	}
	
	public UserServiceImpl() {
	users = new LinkedList<>();
	users.add(new User(1,"SathiyaPriyan"));
	users.add(new User(2,"Hema"));
	users.add(new User(3,"Clement"));
	}

	@Override
	public User getUserid(Integer userid) {
		
		return users.stream().filter(x -> x.getUserId()==userid).findAny().orElse(new User(0,"Not Available"));
				
	}

	@Override
	public void createUser(Integer userid, String username) {
		User user = new User(userid,username);
		 this.users.add(user);
		
		
	}

	@Override
	public void updateUser(Integer userid, String username) {
		users.stream().filter(x -> x.getUserId()==userid).findAny()
		.orElseThrow(() -> new RuntimeException("Item Not Found")).setUsername(username);
	}

	@Override
	public void deleteUser(Integer userid) {
		users.removeIf((User x) ->x.getUserId()==userid);
		
	}
	

}

