package com.beitech.order.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.order.models.Order;
import com.beitech.order.services.OrderService;

@RestController
public class OrderApi {
		
	@Autowired
	private OrderService service;		
	
	@RequestMapping(value="/getOrdersByCustomerAndDate/{customerId}/{fechaInicial}/{fechaFinal}",method = RequestMethod.GET)
	public List<Order> getAllOrders(@PathVariable(value="customerId") Integer customerId,
									@PathVariable(value="fechaInicial") String fechaInicial,
									@PathVariable(value="fechaFinal") String fechaFinal){
		List<Order> result = new ArrayList<Order>();
		System.out.println(customerId);
		result=service.getAllOrdersByClientAndDate(customerId, fechaInicial, fechaFinal);
		
		return result;
	}

}
