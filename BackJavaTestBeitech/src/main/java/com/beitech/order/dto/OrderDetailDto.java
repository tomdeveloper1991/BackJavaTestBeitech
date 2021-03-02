package com.beitech.order.dto;

import com.beitech.order.models.Product;

public class OrderDetailDto {
	
	private Integer orderDetailId;
			
	private Integer orderId;
		
	private Product product;
	
	private String productDescripcion;
		
	private Double price;
	
	private Integer quantity;
		

	public OrderDetailDto(Integer orderDetailId, Integer orderId, Product product, String productDescripcion, Double price, Integer quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.product = product;
		this.productDescripcion = productDescripcion;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductDescripcion() {
		return productDescripcion;
	}

	public void setProductDescripcion(String productDescripcion) {
		this.productDescripcion = productDescripcion;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
		
	
}
