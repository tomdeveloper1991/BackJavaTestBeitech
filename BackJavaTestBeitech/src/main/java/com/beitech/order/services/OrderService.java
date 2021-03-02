package com.beitech.order.services;

import java.util.List;

import com.beitech.order.dto.CreateOrderDto;
import com.beitech.order.dto.OrderDto;
import com.beitech.order.models.Order;

public interface OrderService {
	
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String fechaInicial, String fechaFinal);
	
	public OrderDto createOrder(CreateOrderDto newOrderDto);

}
