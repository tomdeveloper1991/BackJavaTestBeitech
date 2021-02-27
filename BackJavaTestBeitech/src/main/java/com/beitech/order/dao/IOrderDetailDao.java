package com.beitech.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.OrderDetail;

@Repository
public interface IOrderDetailDao extends JpaRepository<OrderDetail, Integer>{

	@Query(value="SELECT * FROM `order_detail` WHERE `order_id`= :orderId ", nativeQuery = true)
	public List<OrderDetail> getAllOrdersDetailsByDetail(@Param("orderId") Integer orderId);
	
}
