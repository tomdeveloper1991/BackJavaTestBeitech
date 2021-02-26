package com.beitech.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.Order;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer>{
	
	@Query(value="SELECT * FROM `order` WHERE `creation_date`>'0000-00-00'", nativeQuery = true)
	public List<Order> getAllOrdersNative();	
	
}
