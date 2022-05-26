package com.ty.food_app_boot.food_app_boot.repostary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.food_app_boot.food_app_boot.dto.Items;

public interface ItemRepositary extends JpaRepository<Items, Integer> {
	
	@Query("select i from Items i where i.order.id=?1")
	public List<Items> getItemsByUserId(int id);

}
