package com.beitech.order.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.order.models.Customer;
import com.beitech.order.models.Order;
import com.beitech.order.models.Product;
import com.beitech.order.services.CustomerService;
import com.beitech.order.services.OrderService;
import com.beitech.order.services.ProductService;

@RestController
public class OrderApi {
		
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/getOrdersByCustomerAndDate/{customerId}/{fechaInicial}/{fechaFinal}",method = RequestMethod.GET)
	public List<Order> getAllOrders(@PathVariable(value="customerId") Integer customerId,
									@PathVariable(value="fechaInicial") String fechaInicial,
									@PathVariable(value="fechaFinal") String fechaFinal){
		List<Order> result = new ArrayList<Order>();
		List<Customer> result2 = new ArrayList<Customer>();
		List<Product> result3 = new ArrayList<Product>();
		
		result=orderService.getAllOrdersByClientAndDate(customerId, fechaInicial, fechaFinal);
		
		result2=customerService.findAll();
		
		for (Customer customer : result2) {
			System.out.println(customer.getCustomerId()+" - "+customer.getName()+" - "+customer.getEmail());
		}
		
		result3=productService.findAll();
		
		for (Product product : result3) {
			System.out.println(product.getProductId()+" - "
								+product.getName()+" - "
								+product.getProductDescription()+" - "
								+product.getPrice());
		}
		
		return result;
	}

}
