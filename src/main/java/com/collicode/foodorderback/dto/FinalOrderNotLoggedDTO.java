package com.collicode.foodorderback.dto;


import com.collicode.foodorderback.model.FinalOrder;

import java.util.Date;

public class FinalOrderNotLoggedDTO {
	public Long id;
	
	private String phoneNumber;
	
	private Date date;
	private int finalPrice;
	private String address;
	private String status;
	
	public FinalOrderNotLoggedDTO() {
		
	}
	
	public FinalOrderNotLoggedDTO(FinalOrder finalOrder) {
		this.id = finalOrder.getId();
		this.phoneNumber = finalOrder.getPhoneNumber();
		this.finalPrice = finalOrder.getFinalPrice();
		this.date = finalOrder.getDate();
		this.address = finalOrder.getAddress();
		this.status = finalOrder.getStatus();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	

}
