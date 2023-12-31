package com.collicode.foodorderback.controller;


import com.collicode.foodorderback.dto.MealTypeDTO;
import com.collicode.foodorderback.model.MealType;
import com.collicode.foodorderback.service.MealTypeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/mealType")
public class MealTypeController {

	@Autowired
	MealTypeService mealTypeService;

	@RequestMapping(value = "/getAllMealTypes", method = RequestMethod.GET)
	public ResponseEntity<List<MealTypeDTO>> getAllMaelTypeList() {
		List<MealTypeDTO> allMealTypeDTOList = mealTypeService.getAllMealTypes();
		return new ResponseEntity<List<MealTypeDTO>>(allMealTypeDTOList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/createMealType", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> createMeal(@RequestParam("image") MultipartFile image, HttpServletRequest request) {
		
		System.out.println(request.getParameter("mealType"));
		
		
		Gson g = new Gson();  
		MealType mealType = g.fromJson(request.getParameter("mealType"), MealType.class);
		
		
		String responseToClient;
		responseToClient = mealTypeService.isValidInput(mealType);
		if (responseToClient.equals("valid")) {
			
			try {
				mealType.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
				mealType.setImageName(image.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//meal.setImage(Base64.getEncoder().encodeToString(file.getBytes()))
			mealTypeService.save(mealType);
			return new ResponseEntity<String>(responseToClient, HttpStatus.OK);

		} else {
			responseToClient = "invalid";
			return new ResponseEntity<String>(responseToClient, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/updateMealType", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> editMealType(@RequestBody MealType mealType){
		String response = mealTypeService.editMealType(mealType);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/deleteMealType/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Long id) {
		String responseToClient;
		MealType mealType = mealTypeService.findOne(id);

		if (mealType == null) {
			responseToClient = "fail";
			return new ResponseEntity<String>(responseToClient, HttpStatus.OK);
		}

		mealTypeService.delete(mealType);
		responseToClient = "success";
		return new ResponseEntity<String>(responseToClient, HttpStatus.OK);
	}
	
	
}