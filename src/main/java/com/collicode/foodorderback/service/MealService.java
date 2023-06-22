package com.collicode.foodorderback.service;


import com.collicode.foodorderback.dto.MealDTO;
import com.collicode.foodorderback.model.Meal;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MealService {
	
	String isValidInput(Meal meal);
	List<MealDTO> findAll();
	Meal save(Meal meal);
	
	Meal delete(Meal meal);
	Meal findOne(Long id);
	String editMeal(Meal meal);
	Long saveImage(byte[] content, String imageName);
	
	List<MealDTO> getMealsByMealTypeId(Long id);
	

}
