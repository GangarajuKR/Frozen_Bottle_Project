package com.ty.food_app_boot.food_app_boot.repostary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.food_app_boot.food_app_boot.dto.User;

public interface UserRepositary extends JpaRepository<User, Integer> {

	@Query("select u From User u where u.email=?1 AND u.password=?2")
	public User vaildEmailAndPassword(String email, String password);

}
