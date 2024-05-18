package com.initial.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.initial.entity.User;
import com.initial.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepo;

	public void addUser(User user) {
		userRepo.save(user);
	}

	// Method to Update the User Details using Id
	public String updateUser(long id, User user) {
		if (searchUser(id) == null) {
			return "User Not Found for updation";
		} else {
			userRepo.save(user);
			return "Record updated successfully";
		}
	}

	public User searchUser(long id) {
		try {
			Optional<User> op = userRepo.findById(id);
			return op.get();
		} catch (NoSuchElementException e) {
			System.out.println("No record found");
		}
		return null;
	}
	public String deleteUserById(long id) {
		if (searchUser(id) != null) {
			userRepo.deleteById(id);
			return "User Deleted";
		}
		return "User Not Found";
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User login(User user) {
		return user;
	}

	public boolean logOut() {
		return true;
	}
}
