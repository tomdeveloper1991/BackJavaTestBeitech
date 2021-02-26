package com.beitech.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.Order;

@Repository
public interface IOrderDao extends JpaRepository<Order, Integer>{
	
	@Query(value="SELECT * FROM test.order WHERE `creation_date` between str_to_date( :fechaInicial ,'%Y%m%d') AND str_to_date( :fechaFinal ,'%Y%m%d') AND `customer_id`= :customerId ORDER BY `creation_date` DESC", nativeQuery = true)
	public List<Order> getAllOrdersByClientAndDate(@Param("customerId") Integer customerId,
											@Param("fechaInicial") String fechaInicial,
											@Param("fechaFinal") String fechaFinal);
	
}
