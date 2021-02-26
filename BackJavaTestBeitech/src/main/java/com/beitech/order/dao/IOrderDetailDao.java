package com.beitech.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.order.models.OrderDetail;

@Repository
public interface IOrderDetailDao extends JpaRepository<OrderDetail, Integer>{

}
