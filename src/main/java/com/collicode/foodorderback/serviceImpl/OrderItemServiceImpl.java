package com.collicode.foodorderback.serviceImpl;

import com.collicode.foodorderback.dto.ItemFromCartDTO;
import com.collicode.foodorderback.model.OrderItem;
import com.collicode.foodorderback.repository.OrderItemRepository;
import com.collicode.foodorderback.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
	
	@Override
	public List<OrderItem> findAll(){
		List<OrderItem> allOrderItems = orderItemRepository.findAll();
		return allOrderItems;
		
	}
	
	@Override
	public List<OrderItem> getOrderItemsByFinalOrderId(Long finalOrderId){
		List<OrderItem> allOrderItems = orderItemRepository.findAll();
		List<OrderItem> orderItemsByFinalOrderId = new ArrayList<OrderItem>();
		for(OrderItem oi: allOrderItems) {
			if(oi.getFinalOrder().getId() == finalOrderId) {
				orderItemsByFinalOrderId.add(oi);
			}
		}
		return orderItemsByFinalOrderId;
	}
	
	@Override
	public List<ItemFromCartDTO> getItemFromCartByFinalOrderId(Long finalOrderId){
		List<OrderItem> allOrderItems = orderItemRepository.findAll();
		List<ItemFromCartDTO> itemsFromCartByFinalOrderIdDTO = new ArrayList<ItemFromCartDTO>();
		for(OrderItem oi: allOrderItems) {
			if(oi.getFinalOrder().getId() == finalOrderId) {
				itemsFromCartByFinalOrderIdDTO.add(new ItemFromCartDTO(oi));
			}
		}
		return itemsFromCartByFinalOrderIdDTO;
	}
}
