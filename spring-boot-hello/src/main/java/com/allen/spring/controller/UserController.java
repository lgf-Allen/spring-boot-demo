/**
 * 
 */
package com.allen.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.bean.User;

/**
 * @author meng
 *
 */
@RestController
@RequestMapping(path="/users")
public class UserController {

	@GetMapping(path="user")
	public User getUserByUsername(@RequestParam(value="username")String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("xxxxxx");
		user.setAge(25);
		user.setGender("男");
		return user;
	}
	
	
	@GetMapping
	public List<User> getAllUser(){
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setUsername("Allen");
		user1.setPassword("xxxxxx");
		user1.setAge(20);
		user1.setGender("female");
		User user2 = new User();
		user2.setUsername("Lingfeng");
		user2.setPassword("xxxxxx");
		user2.setAge(20);
		user2.setGender("male");
		list.add(user1);
		list.add(user2);
		return list;
	}
	
	@DeleteMapping
	public void deleteUserByUsername(@RequestParam(value="username")String username) {
		System.out.println("Delete successed");
	}
}
