package com.beitech.order.dto;

import java.util.Date;
import java.util.List;

import com.beitech.order.models.OrderDetail;

public class OrderDto {
	
	private Integer orderId;
		
	private Integer customerId;
		
	private Date creationDate;
		
	private String deliveryAddress;
		
	private Double total;
	
	private List<OrderDetailDto> orderDetailDto;

	

	public OrderDto(Integer orderId, Integer customerId, Date creationDate, String deliveryAddress, Double total, List<OrderDetailDto> orderDetailDto) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.creationDate = creationDate;
		this.deliveryAddress = deliveryAddress;
		this.total = total;
		this.orderDetailDto = orderDetailDto;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<OrderDetailDto> getOrderDetailDto() {
		return orderDetailDto;
	}

	public void setOrderDetailDto(List<OrderDetailDto> orderDetailDto) {
		this.orderDetailDto = orderDetailDto;
	}

	
}
