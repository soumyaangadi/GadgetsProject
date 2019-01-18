package com.niit.Luvbro.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;

//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name ="Cart")
@Component
public class Cart 
{
  @Id
   private String cart_Id;
   private double grandtotal = 0.0;
   private long totalitems=0;
   
   @OneToMany(mappedBy="cart" ,fetch=FetchType.EAGER)
   private List<CartItems> cartItems;
   
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="U_id")
   private User user;
   
   public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Cart()
 	{
 		this.cart_Id="cart"+UUID.randomUUID().toString().substring(30).toUpperCase();
 	}

public List<CartItems> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartItems> cartItems) {
	this.cartItems = cartItems;
}
public String getCart_Id() {
	return cart_Id;
}
public void setCart_Id(String cart_Id) {
	this.cart_Id = cart_Id;
}
public double getGrandtotal() {
	return grandtotal;
}
public void setGrandtotal(double grandtotal) {
	this.grandtotal = grandtotal;
}
public long getTotalitems() {
	return totalitems;
}
public void setTotalitems(long totalitems) {
	this.totalitems = totalitems;
	
}

}
