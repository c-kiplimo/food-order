package com.collicode.foodorderback.service;


import com.collicode.foodorderback.dto.ItemFromCartDTO;
import com.collicode.foodorderback.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {
	
	OrderItem save(OrderItem orderItem);
	List<OrderItem> findAll();
	List<OrderItem> getOrderItemsByFinalOrderId(Long finalOrderId);
	List<ItemFromCartDTO> getItemFromCartByFinalOrderId(Long finalOrderId);

}
