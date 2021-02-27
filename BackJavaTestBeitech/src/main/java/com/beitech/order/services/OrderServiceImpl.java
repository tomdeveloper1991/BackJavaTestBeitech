package com.beitech.order.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.IOrderDao;
import com.beitech.order.models.Order;

@Service
@Configurable
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private IOrderDao iOrderDao;
	
	@Override
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String startDateSrt, String endDateStr){
		
		List<Order> result = new ArrayList<Order>();
		
		try {
			
			Date startDate=new SimpleDateFormat("yyyyMMdd").parse(startDateSrt);
			Date endDate=new SimpleDateFormat("yyyyMMdd").parse(endDateStr);
						
			result = iOrderDao.findByCustomerCustomerIdAndCreationDateGreaterThanEqualAndCreationDateLessThanEqual(customerId, startDate, endDate);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
