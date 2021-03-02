package com.beitech.order.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.ICustomerDao;
import com.beitech.order.dao.ICustomerProductDao;
import com.beitech.order.dao.IOrderDao;
import com.beitech.order.dao.IOrderDetailDao;
import com.beitech.order.dao.IProductDao;
import com.beitech.order.dto.CreateOrderDetailDTO;
import com.beitech.order.dto.CreateOrderDto;
import com.beitech.order.dto.OrderDetailDto;
import com.beitech.order.dto.OrderDto;
import com.beitech.order.models.Customer;
import com.beitech.order.models.CustomerProduct;
import com.beitech.order.models.Order;
import com.beitech.order.models.OrderDetail;
import com.beitech.order.models.Product;
import com.beitech.order.utils.Utility;
import com.beitech.order.utils.exception.BadRequest;
import com.beitech.order.utils.exception.NotFoundException;


@Service
@Configurable
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private IOrderDao iOrderDao;
	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Autowired
	private IProductDao iProductDao;
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao;
	
	@Autowired
	private IOrderDetailDao iOrderDetailDao;
	
	private Utility utils =  new Utility();
	
	private static final Logger Log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private static final String ERROR_CUSTOMER_MSJ="Customer does not exists";
	private static final String ERROR_PRODUCT_MSJ="Product does not exists";
	private static final String ERROR_CUSTOMER_PRODUCT_MSJ="Product is not avaiable to the customer";
	private static final String ERROR_NUM_PRODUCTS_MSJ="The order cannot have more than 5 products";
	
	@Override
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String startDateSrt, String endDateStr){
		
		List<Order> result = new ArrayList<Order>();
		
		
		if (!iCustomerDao.existsById(customerId)) {
			Log.error(ERROR_CUSTOMER_MSJ);
			throw new NotFoundException(ERROR_CUSTOMER_MSJ);
		}
		
		try {
			
			Date startDate=new SimpleDateFormat("yyyyMMdd").parse(startDateSrt);
			Date endDate=new SimpleDateFormat("yyyyMMdd").parse(endDateStr);
						
			result = iOrderDao.findByCustomerCustomerIdAndCreationDateGreaterThanEqualAndCreationDateLessThanEqual(customerId, startDate, endDate);
						
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw new BadRequest(e.getMessage());
		}
		
		return result;
	}
	
	public OrderDto createOrder(CreateOrderDto newOrderDto) {				
		
		Customer customer = iCustomerDao.findById(newOrderDto.getCustomerId()).orElseThrow(()->new NotFoundException(ERROR_CUSTOMER_MSJ));				
		
		List<CustomerProduct> customerProducts = iCustomerProductDao.findByCustomerProductIdCustomerId(newOrderDto.getCustomerId());
			
		Product productAux = null;			
		
		Integer ProductsCounter=0;
		
		Double total = 0.0;
				
		for (CreateOrderDetailDTO newOrderDetailDto : newOrderDto.getProducts()) {
			
			if (!iProductDao.existsById(newOrderDetailDto.getProductId())) {
				Log.error(ERROR_PRODUCT_MSJ);
				throw new NotFoundException(ERROR_PRODUCT_MSJ);
			}else {				
				customerProducts.stream().filter(p->p.getCustomerProductId().getProductId().equals(newOrderDetailDto.getProductId())).findFirst().orElseThrow(()->new NotFoundException(ERROR_CUSTOMER_PRODUCT_MSJ));				
			}
			
			ProductsCounter+=newOrderDetailDto.getQuantity();
			
			productAux = iProductDao.findById(newOrderDetailDto.getProductId()).orElseThrow(()->new NotFoundException(ERROR_PRODUCT_MSJ));
			
			total+=productAux.getPrice()*newOrderDetailDto.getQuantity();
								
			if (ProductsCounter>5) {
				throw new BadRequest(ERROR_NUM_PRODUCTS_MSJ);
			}					
		}
		
		Order newOrder = new Order(customer, this.utils.convertStringToDate(newOrderDto.getCreationDate()), newOrderDto.getDeliveryAddress(), new Double(total));
		
		iOrderDao.save(newOrder);
		
		List<OrderDetailDto> orderDetailDtoList = new ArrayList<OrderDetailDto>();
		
		total=0.0;
		
		for (CreateOrderDetailDTO newOrderDetailDto : newOrderDto.getProducts()) {
			productAux = iProductDao.findById(newOrderDetailDto.getProductId()).orElseThrow(()->new NotFoundException(ERROR_PRODUCT_MSJ));
			
			total=productAux.getPrice()*newOrderDetailDto.getQuantity();
			
			OrderDetail orderDetail = new OrderDetail(newOrder, productAux, newOrderDetailDto.getProductDescription(), total, newOrderDetailDto.getQuantity());
			
			iOrderDetailDao.save(orderDetail);
			
			orderDetailDtoList.add(new OrderDetailDto(orderDetail.getOrderDetailId(), orderDetail.getOrder().getOrderId(), productAux, orderDetail.getProductDescripcion(), orderDetail.getPrice(), orderDetail.getQuantity()));
		}
		
		OrderDto newOrderDtoResponse = new OrderDto(newOrder.getOrderId(), newOrder.getCustomer().getCustomerId(), newOrder.getCreationDate(), newOrder.getDeliveryAddress(), newOrder.getTotal(), orderDetailDtoList);
				
		return newOrderDtoResponse;
	}

}
