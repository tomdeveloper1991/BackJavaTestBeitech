package com.beitech.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.beitech.order.dao.IOrderDetailDao;
import com.beitech.order.models.OrderDetail;

@Service
@Configurable
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private IOrderDetailDao iOrderDetailDao;
	
	public List<OrderDetail> findAll(){
		return iOrderDetailDao.findAll();
	}
}
