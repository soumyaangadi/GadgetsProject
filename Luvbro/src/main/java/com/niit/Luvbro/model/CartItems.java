package com.niit.Luvbro.model;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

//import org.springframework.stereotype.Component;


@Entity
@Table(name ="CartItems")
@Component
public class CartItems 
{
	@Id
	private String c_id;
	private float price;
	
	@ManyToOne
	@JoinColumn(name="cart_Id")
	private Cart cart;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="p_id")
	private Product product;

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	
}
