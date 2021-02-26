package com.beitech.order.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_detail_id")	
	@NotNull
	private Integer orderDetailId;
		
	@Column(name="order_id")
	@NotNull
	private Integer orderId;
	
	@Column(name="product_id")
	@NotNull
	private Integer productId;
	
	@Column(name="product_description")
	@NotNull
	private String productDescripcion;
	
	@Column(name="price")
	@NotNull
	private Double price;

	@Column(name="quantity")
	@NotNull
	private Integer quantity;
	
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(Integer orderId,Integer productId,String productDescripcion,Double price,Integer quantity) {
		super();
		this.orderId=orderId;
		this.productId=productId;
		this.productDescripcion=productDescripcion;
		this.price=price;
		this.quantity=quantity;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
