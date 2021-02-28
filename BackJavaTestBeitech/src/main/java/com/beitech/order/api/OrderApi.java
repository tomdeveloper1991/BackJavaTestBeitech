package com.beitech.order.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.order.dao.IOrderDao;
import com.beitech.order.dto.CreateOrderDetailDTO;
import com.beitech.order.dto.CreateOrderDto;
import com.beitech.order.models.Customer;
import com.beitech.order.models.Order;
import com.beitech.order.models.Product;
import com.beitech.order.services.CustomerProductService;
import com.beitech.order.services.CustomerService;
import com.beitech.order.services.OrderDetailService;
import com.beitech.order.services.OrderService;
import com.beitech.order.services.OrderServiceImpl;
import com.beitech.order.services.ProductService;
import com.beitech.order.utils.exception.InternalServerError;

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
	
	private static final Logger Log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@GetMapping(value="/getOrdersByCustomerAndDate/{customerId}/{fechaInicial}/{fechaFinal}")	
	public ResponseEntity<List<Order>> getOrdersByCustomerAndDate(	@PathVariable(value="customerId") Integer customerId,
																	@PathVariable(value="fechaInicial") String fechaInicial,
																	@PathVariable(value="fechaFinal") String fechaFinal){
		
		List<Order> result = new ArrayList<Order>();
		try {
			result=orderService.getAllOrdersByClientAndDate(customerId, fechaInicial, fechaFinal);
		}catch (Exception e) {
			Log.error(e.getMessage());
			throw new InternalServerError(e.getMessage());
		}														
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping(value="/createOrder")
	public ResponseEntity<CreateOrderDto>createOrder(@RequestBody CreateOrderDto orderDto) {
		try {						
			Log.info("customerId.OrderId"+orderDto.getCreationDate());
			CreateOrderDto request = new CreateOrderDto();
			List<CreateOrderDetailDTO> products = new ArrayList<CreateOrderDetailDTO>();
						
			orderService.createOrder(orderDto);
			
			/*CreateOrderDetailDTO product = new CreateOrderDetailDTO(1, "Sin cubiertos ni servilletas", 3);
			CreateOrderDetailDTO product2 = new CreateOrderDetailDTO(1, "Sin salsas", 2);	
			CreateOrderDetailDTO product3 = new CreateOrderDetailDTO(1, "Sin Azucar", 1);
			
			products.add(product);
			products.add(product2);
			products.add(product3);
			
			request.setCreationDate("20210602");
			request.setCustomerId(7);
			request.setDeliveryAddress("Avenida Siempre viva 123");
			
			request.setProducts(products);*/
										
			return ResponseEntity.status(HttpStatus.OK).body(request);
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw new InternalServerError(e.getMessage());
		}			
	}

}
