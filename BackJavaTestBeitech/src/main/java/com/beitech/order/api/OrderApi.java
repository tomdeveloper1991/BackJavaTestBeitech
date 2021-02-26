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
		
	@RequestMapping(value="/getAllOrders",method = RequestMethod.GET)
	public List<Order> getAllOrders(){
		List<Order> lista = new ArrayList<Order>();
		
		lista=service.getAllOrders();
				
		return lista;
	}
	
	@RequestMapping(value="/getOrdersByCustomerAndDate/{customerId}",method = RequestMethod.GET)
	public List<Order> getAllOrders(@PathVariable(value="customerId") int customerId){
		List<Order> lista = new ArrayList<Order>();
		System.out.println(customerId);
		lista=service.getAllOrders();
		
		return lista;
	}

}
