package com.niit.Luvbro.model;

import java.util.UUID;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="OrderItems")
@Component//orderItems
public class OrderItems 
{
	@Id
	private String orderitem_id;
	private String p_id;
	
	public OrderItems() {
		this.orderitem_id = "ORDERITEM" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@ManyToOne
	@JoinColumn(name="o_id")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
	
	

}
