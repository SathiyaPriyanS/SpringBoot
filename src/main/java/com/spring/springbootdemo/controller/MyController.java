package com.spring.springbootdemo.controller;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootdemo.service.UserService;
import com.springspringbootdemo.model.User;

@RestController
@RequestMapping("/user")
public class MyController {
	
	@RequestMapping("")
	public ResponseEntity<String> hai()
	{
		return new ResponseEntity<String>("Hello Sathiya",HttpStatus.OK);
	}

/*	
	 @RequestMapping("/test")
	   public Map<String,Object> test(){
		   Map<String,Object> map = new LinkedHashMap<>();
		   map.put("Age","22");
		   return map;
	 }
*/
	@Autowired
	UserService userService;
	
	@RequestMapping("/allusers")
	public List<User> getAllUsers(){

		/*Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", "Get All Users Implementation");
		return map;*/
	return userService.getAllUsers();
	}
	
	
	@RequestMapping("/{id}")
	
/*
	public Map<String, Object>  getAllUser(@PathVariable("id") Integer id){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", "Get User Implementation based on id");
		return map;
		*/
	
	public User getUser(@PathVariable("id")Integer id) {
		return userService.getUserid(1);
	}
	
	
	@RequestMapping(value="",method = RequestMethod.POST)
	public Map<String, Object>  createUser(@RequestParam(value="userid")Integer userid,
			@RequestParam(value="username")String username){
	
		Map<String, Object> map = new LinkedHashMap<>();
		userService.createUser(userid, username);
		map.put("result", "created a new  Users ");
		return map;
	}
	
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	public Map<String, Object>  updateUser(@RequestParam(value="userid")Integer userid,
			@RequestParam(value="username")String username){
		
		Map<String, Object> map = new LinkedHashMap<>();
		userService.updateUser(userid, username);
		map.put("result", "Updated a User");
		return map;
	}

	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public Map<String, Object>  deleteUser(@RequestParam(value="userid")Integer userid){
		
		Map<String, Object> map = new LinkedHashMap<>();
		userService.deleteUser(userid);
		map.put("result", "Deleted the User");
		return map;
	}	
}

