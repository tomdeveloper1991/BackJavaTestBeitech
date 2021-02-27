package com.beitech.order.services;

import java.util.List;
import java.util.Optional;

import com.beitech.order.models.OrderDetail;

public interface OrderDetailService {

	public List<OrderDetail> findAll();
	
}
