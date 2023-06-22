package com.collicode.foodorderback.service;


import com.collicode.foodorderback.dto.FinalOrderDTO;
import com.collicode.foodorderback.dto.FinalOrderIdAndStatusDTO;
import com.collicode.foodorderback.dto.OrderItemDTO;
import com.collicode.foodorderback.model.FinalOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinalOrderService {
	
	FinalOrder save(FinalOrder finalOrder);
	Long makeFinalOrder(OrderItemDTO orderItemDTO);
	FinalOrder findOne(Long id);
	List<FinalOrderDTO> getAllActiveFinalOrders();
	List<FinalOrderDTO> getAllDeliveredFinalOrders();
	String setFinalOrderToDelivered(Long finalOrderId);
	List<FinalOrderDTO> getAllMyActiveFinalOrders(Long currentUserId);
	List<FinalOrderDTO> getAllMyDeliveredFinalOrders(Long currentUserId);
	String changeFinalOrderStatus (FinalOrderIdAndStatusDTO foIdStatus);

}
