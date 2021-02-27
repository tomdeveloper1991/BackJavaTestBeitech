package com.beitech.order.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="`order_detail`")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="`order_detail_id`")	
	@NotNull
	private Integer orderDetailId;
		
	@ManyToOne
	@JoinColumn(name = "`order_id`", referencedColumnName = "`order_id`", nullable=false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "`product_id`", referencedColumnName = "`product_id`", nullable=false)
	private Product product;
	
	@Column(name="`product_description`")
	@NotNull
	private String productDescripcion;
	
	@Column(name="`price`")
	@NotNull
	private Double price;

	@Column(name="`quantity`")
	@NotNull
	private Integer quantity;
	
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(Order order,Product product,String productDescripcion,Double price,Integer quantity) {
		super();
		this.order=order;
		this.product=product;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProductId() {
		return product;
	}

	public void setProductId(Product product) {
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
