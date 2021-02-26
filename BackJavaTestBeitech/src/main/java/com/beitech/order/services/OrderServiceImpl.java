package com.beitech.order.services;

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
	public List<Order> getAllOrdersByClientAndDate(Integer customerId, String fechaInicial, String fechaFinal){
		
		List<Order> result = iOrderDao.getAllOrdersByClientAndDate(customerId, fechaInicial, fechaFinal);
		
		return result;
	}

}
