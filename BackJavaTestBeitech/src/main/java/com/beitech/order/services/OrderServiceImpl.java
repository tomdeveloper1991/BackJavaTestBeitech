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
import com.beitech.order.dao.IOrderDao;
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
	
	private static final Logger Log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Override
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String startDateSrt, String endDateStr){
		
		List<Order> result = new ArrayList<Order>();
		
		
		if (!iCustomerDao.existsById(customerId)) {
			throw new NotFoundException("Customer does not exists");
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

}
