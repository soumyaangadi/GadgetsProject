package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.OrderItems;

//import java.util.List;

public interface OrderItemsDao 
{
	public boolean saveOrUpdate(OrderItems orderitems);
	public boolean delete(OrderItems orderitems);
	public OrderItems getOrderItems(String id);
	public List<OrderItems> list();
	public List<OrderItems> getOrderItemsbyOrder(String o_id);

}
