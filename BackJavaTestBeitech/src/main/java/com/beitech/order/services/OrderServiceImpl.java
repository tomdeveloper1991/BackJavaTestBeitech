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
import com.beitech.order.dao.IProductDao;
import com.beitech.order.dto.CreateOrderDetailDTO;
import com.beitech.order.dto.CreateOrderDto;
import com.beitech.order.models.CustomerProduct;
import com.beitech.order.models.Order;
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
	
	public Order createOrder(CreateOrderDto newOrderDto) {
		
		if(!iCustomerDao.existsById(newOrderDto.getCustomerId())) {
			Log.error(ERROR_CUSTOMER_MSJ);
			throw new NotFoundException(ERROR_CUSTOMER_MSJ);
		}
		
		Integer ProductsCounter=0;
		
		List<CustomerProduct> customerProducts = iCustomerProductDao.findByCustomerId(newOrderDto.getCustomerId());
		
		
		
		for (CreateOrderDetailDTO newOrderDetailDto : newOrderDto.getProducts()) {
			
			if (!iProductDao.existsById(newOrderDetailDto.getProductId())) {
				Log.error(ERROR_PRODUCT_MSJ);
				throw new NotFoundException(ERROR_PRODUCT_MSJ);
			}else {
				for (CustomerProduct customerProduct : customerProducts) {
					if (!(customerProduct.getProduct().getProductId()==newOrderDetailDto.getProductId())) {
						throw new BadRequest(ERROR_CUSTOMER_PRODUCT_MSJ);
					}																		
				}
			}
			
			ProductsCounter+=newOrderDetailDto.getQuantity();
			
			if (ProductsCounter>5) {
				throw new BadRequest(ERROR_NUM_PRODUCTS_MSJ);
			}
			
		}
		
		
		
		
		
		
		
		//Order newOrder = new Order(newOrderDto.getCustomerId(), creationDate, deliveryAddress, total)
		
		return null;
	}

}
