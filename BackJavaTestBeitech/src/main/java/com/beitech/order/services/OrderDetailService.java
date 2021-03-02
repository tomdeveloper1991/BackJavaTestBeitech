package com.beitech.order.services;

import java.util.List;

import com.beitech.order.models.OrderDetail;

public interface OrderDetailService {

	public List<OrderDetail> findAll();
	
}
