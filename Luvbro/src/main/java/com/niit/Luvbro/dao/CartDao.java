package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Cart;

//import java.util.List;

public interface CartDao 
{
	public boolean saveOrUpdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String id);
	public List<Cart> list();

}
