package com.ty.food_app_boot.food_app_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.food_app_boot.food_app_boot.dto.User;
import com.ty.food_app_boot.food_app_boot.repostary.UserRepositary;

@Repository
public class UserDao {

	@Autowired
	UserRepositary repositary;

	public User saveUser(User user) {
		return repositary.save(user);
	}

	public User getUserById(int id) {
		Optional<User> opt = repositary.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public boolean deletebyId(@RequestParam int id) {
		User user = getUserById(id);
		if (user != null) {
			repositary.deleteById(id);
			return true;
		}
		return false;
	}

	public List<User> getalluser() {
		return repositary.findAll();
	}

	public User update(int id, User user) {
		User u = getUserById(id);
		if (u != null) {
			return repositary.save(user);
		}
		return null;
	}

	public User valid(String email, String password) {
		User u = repositary.vaildEmailAndPassword(email, password);
		if (u != null) {
			return u;
		}
		return null;

	}

}
