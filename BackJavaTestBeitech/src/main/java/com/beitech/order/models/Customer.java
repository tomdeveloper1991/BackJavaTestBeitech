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
@Table(name = "`customer`")
public class Customer implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`customer_id`")
	@NotNull
	private Integer customerId;
	
	@Column(name = "`name`")
	@NotNull
	private String name;
	
	@Column(name = "`email`")
	@NotNull
	private String email;
		
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String email) {
		super();
		this.name=name;
		this.email=email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
