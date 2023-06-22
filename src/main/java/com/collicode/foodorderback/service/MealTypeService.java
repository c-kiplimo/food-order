package com.collicode.foodorderback.service;


import com.collicode.foodorderback.dto.MealTypeDTO;
import com.collicode.foodorderback.model.MealType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealTypeService {
	public List<MealTypeDTO> getAllMealTypes();
	public String isValidInput(MealType mealType);
	public MealType save(MealType mealType);
	public String editMealType(MealType mealType);
	public MealType findOne(Long id);
	public MealType delete(MealType mealType);
}
