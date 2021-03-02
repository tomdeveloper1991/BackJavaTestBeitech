package com.beitech.order.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.Order;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer>{	
		
	public List<Order> findByCustomerCustomerIdAndCreationDateGreaterThanEqualAndCreationDateLessThanEqual(Integer customerId,Date startDate,Date endDate);
	
}
