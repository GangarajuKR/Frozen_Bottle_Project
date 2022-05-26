package com.ty.food_app_boot.food_app_boot.repostary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.food_app_boot.food_app_boot.dto.Person;

public interface PersonRepositary extends JpaRepository<Person, Integer> {
	@Query("select p from Person p where p.email=?1")
	public Person validateEmail(String email);

}
