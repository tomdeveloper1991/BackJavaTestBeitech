package com.beitech.order.services;

import java.util.List;


import com.beitech.order.models.Order;

public interface OrderService {
	
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String fechaInicial, String fechaFinal);

}
