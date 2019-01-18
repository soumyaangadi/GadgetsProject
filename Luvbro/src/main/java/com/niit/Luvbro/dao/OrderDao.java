package com.niit.Luvbro.dao;



import java.util.List;

import com.niit.Luvbro.model.Order;

public interface OrderDao 
{
	public boolean saveOrUpdate(Order order);
	public boolean delete(Order order);
	public Order getOrder(String id);
	public List<Order> list();

}
