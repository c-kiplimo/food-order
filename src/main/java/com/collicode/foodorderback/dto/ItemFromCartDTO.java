package com.collicode.foodorderback.dto;


import com.collicode.foodorderback.model.Meal;
import com.collicode.foodorderback.model.OrderItem;

public class ItemFromCartDTO {
	
	private Meal meal;
	private int quantity;
	
	public ItemFromCartDTO() {
		
	}
	
	public ItemFromCartDTO(OrderItem orderItem) {
		this.meal = orderItem.getMeal();
		this.quantity = orderItem.getQuantity();
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
