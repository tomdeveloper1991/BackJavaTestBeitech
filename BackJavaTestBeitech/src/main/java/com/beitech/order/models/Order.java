package com.beitech.order.models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="`order`")
public class Order implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`order_id`")
	@NotNull
	private Integer orderId;
		
	@ManyToOne
	@JoinColumn(name = "`customer_id`", referencedColumnName = "`customer_id`", nullable=false)
	private Customer customer;
	
	@Column(name = "`creation_date`")	
	private Date creationDate;
	
	@Column(name = "`delivery_address`")
	@NotNull
	private String deliveryAddress;
	
	@Column(name = "`total`")
	@NotNull
	private Double total;
	
	public Order() {
		super();
	}
	
	public Order(Customer customer, Date creationDate, String deliveryAddress, Double total) {
		super();
		this.customer=customer;
		this.creationDate=creationDate;
		this.deliveryAddress=deliveryAddress;
		this.total=total;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
	
	
}
