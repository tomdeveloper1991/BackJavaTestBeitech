package com.beitech.order.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.order.dto.CreateOrderDto;
import com.beitech.order.models.Customer;
import com.beitech.order.models.Order;
import com.beitech.order.models.Product;
import com.beitech.order.services.CustomerProductService;
import com.beitech.order.services.CustomerService;
import com.beitech.order.services.OrderDetailService;
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
	
	@Autowired
	private CustomerProductService customerProductService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping(value="/getOrdersByCustomerAndDate/{customerId}/{fechaInicial}/{fechaFinal}")	
	public List<Order> getAllOrders(@PathVariable(value="customerId") Integer customerId,
									@PathVariable(value="fechaInicial") String fechaInicial,
									@PathVariable(value="fechaFinal") String fechaFinal){
		List<Order> result = new ArrayList<Order>();		
		
		result=orderService.getAllOrdersByClientAndDate(customerId, fechaInicial, fechaFinal);
									
		return result;
	}
	
	@PostMapping(value="/createOrder")
	public Object createOrder(@RequestBody Order customerId) {
		System.out.println(customerId.getOrderId());
		
		CreateOrderDto request = new CreateOrderDto();
		List<Product> products = new ArrayList<Product>();
		
		Product product = new Product("Producto 1", "Producto de Prueba 1", 10000.0);
		Product product2 = new Product("Producto 2", "Producto de Prueba 2", 20000.0);	
		Product product3 = new Product("Producto 3", "Producto de Prueba 3", 30000.0);
		
		products.add(product);
		products.add(product2);
		products.add(product3);			
		
		request.setCreationDate("20210602");
		request.setCustomerId(7);
		request.setDeliveryAddress("Avenida Siempre viva 123");
		
		request.setProducts(products);		
		
		return request;
	}
	
	@RequestMapping(value="/getTest",method = RequestMethod.GET)
	public Object getTest(){
		Object result = new Object();
			
		result=customerService.findAll();
		result=productService.findAll();		
		result=orderDetailService.findAll();
		result=customerProductService.findByIdCustomer(1);
		
		return result;
	}

}
