package com.initial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.initial.entity.User;
import com.initial.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userServ;

	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		userServ.addUser(user);
		return user;
	}

	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		return userServ.updateUser(id, user);
	}

	@GetMapping("/searchUser/{id}")
	public User getUser(@PathVariable long id) {
		return userServ.searchUser(id);
	}

		@DeleteMapping("/deleteUser/{id}")
		public String deleteUser(@PathVariable long id) {
			return userServ.deleteUserById(id);
		}

	@GetMapping("/showUsers")
	public List<User> getAllUsers() {
		return userServ.getAllUsers();
	}

}
