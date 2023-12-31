package com.collicode.foodorderback.controller;


import com.collicode.foodorderback.dto.FinalOrderDTO;
import com.collicode.foodorderback.dto.FinalOrderIdAndStatusDTO;
import com.collicode.foodorderback.dto.ItemFromCartDTO;
import com.collicode.foodorderback.dto.OrderItemDTO;
import com.collicode.foodorderback.model.FinalOrder;
import com.collicode.foodorderback.model.User;
import com.collicode.foodorderback.service.FinalOrderService;
import com.collicode.foodorderback.service.OrderItemService;
import com.collicode.foodorderback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/finalOrder")
public class FinalOrderController {
	
	
	@Autowired
	FinalOrderService finalOrderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/welcomeTest", method = RequestMethod.GET)
	public String welcome() {
		return "IDEMO NISSSS!!!";
	}
	
	@RequestMapping(value ="/createFinalOrder",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> saveFinalOrderUser(@RequestBody OrderItemDTO orderItemDTO){
		Long responseToClient;		
		responseToClient = finalOrderService.makeFinalOrder(orderItemDTO);
		return new ResponseEntity<Long>(responseToClient, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getFinalOrderById/{id}", method = RequestMethod.GET)
	public ResponseEntity<FinalOrder> getFinalOrderById(@PathVariable Long id){
		FinalOrder finalOrder = new FinalOrder();
		try {
			finalOrder = finalOrderService.findOne(id);
			
		} catch (Exception e) {
			finalOrder = new FinalOrder();
		}
		
		return new ResponseEntity<FinalOrder>(finalOrder, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAllDeliveredFinalOrders", method = RequestMethod.GET)
	public ResponseEntity<List<FinalOrderDTO>> getAllDeliveredFinalOrders(){
		List<FinalOrderDTO> allDeliveredFinalOrders = new ArrayList<FinalOrderDTO>();
		allDeliveredFinalOrders = finalOrderService.getAllDeliveredFinalOrders();
		return new ResponseEntity<List<FinalOrderDTO>>(allDeliveredFinalOrders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAllActiveFinalOrders", method = RequestMethod.GET)
	public ResponseEntity<List<FinalOrderDTO>> getAllActiveFinalOrders(){	
		List<FinalOrderDTO> allActiveFinalOrders = new ArrayList<FinalOrderDTO>();
		allActiveFinalOrders = finalOrderService.getAllActiveFinalOrders();
		return new ResponseEntity<List<FinalOrderDTO>>(allActiveFinalOrders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAllMyActiveFinalOrders", method = RequestMethod.GET)
	public ResponseEntity<List<FinalOrderDTO>> getAllMyActiveFinalOrders(){	
		List<FinalOrderDTO> allMyActiveFinalOrders = new ArrayList<FinalOrderDTO>();
		User currentUser = new User();
		try {
			currentUser = userService.getCurrentUser();
		} catch (Exception e) {
			return new ResponseEntity<List<FinalOrderDTO>>(allMyActiveFinalOrders, HttpStatus.NOT_FOUND);
		}
		
		allMyActiveFinalOrders = finalOrderService.getAllMyActiveFinalOrders(currentUser.getId());
		return new ResponseEntity<List<FinalOrderDTO>>(allMyActiveFinalOrders, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getAllMyDeliveredFinalOrders", method = RequestMethod.GET)
	public ResponseEntity<List<FinalOrderDTO>> getAllMyDeliveredFinalOrders(){	
		List<FinalOrderDTO> allMyDeliveredFinalOrders = new ArrayList<FinalOrderDTO>();
		User currentUser = new User();
		try {
			currentUser = userService.getCurrentUser();
		} catch (Exception e) {
			return new ResponseEntity<List<FinalOrderDTO>>(allMyDeliveredFinalOrders, HttpStatus.NOT_FOUND);
		}
		
		allMyDeliveredFinalOrders = finalOrderService.getAllMyDeliveredFinalOrders(currentUser.getId());
		return new ResponseEntity<List<FinalOrderDTO>>(allMyDeliveredFinalOrders, HttpStatus.OK);
	}
	
//	@RequestMapping(value ="/getFinalOrderById/{id}", method = RequestMethod.GET)
//	public ResponseEntity<FinalOrderNotLoggedDTO> getFinalOrderById(@PathVariable Long id){
//		FinalOrderNotLoggedDTO finalOrderNotLoggedDTO = new FinalOrderNotLoggedDTO();
//		try {
//			FinalOrder finalOrder = finalOrderService.findOne(id);
//			finalOrderNotLoggedDTO = new FinalOrderNotLoggedDTO(finalOrder);
//		} catch (Exception e) {
//			finalOrderNotLoggedDTO = new FinalOrderNotLoggedDTO();
//		}
//		
//		return new ResponseEntity<FinalOrderNotLoggedDTO>(finalOrderNotLoggedDTO, HttpStatus.OK);
//	}
	
	@RequestMapping(value ="/getOrderItemsByFinalOrderId/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<ItemFromCartDTO>> getOrderItemsByFinalOrderId(@PathVariable Long id){
		List<ItemFromCartDTO> itemsFromCartByFinalOrderId = new ArrayList<ItemFromCartDTO>();
		itemsFromCartByFinalOrderId = orderItemService.getItemFromCartByFinalOrderId(id);
		return new ResponseEntity<List<ItemFromCartDTO>>(itemsFromCartByFinalOrderId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/setFinalOrderToDelivered/{finalOrderId}", method = RequestMethod.PUT)
	public ResponseEntity<String> setFinalOrderToDelivered(@PathVariable Long finalOrderId){
		String response = finalOrderService.setFinalOrderToDelivered(finalOrderId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/changeStatus", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> editStatus(@RequestBody FinalOrderIdAndStatusDTO foIdStatus){
		String response = finalOrderService.changeFinalOrderStatus(foIdStatus);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
}
