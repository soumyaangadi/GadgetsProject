package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.OrderDao;
//import com.niit.Luvbro.dao.OrderDao;
import com.niit.Luvbro.dao.OrderItemsDao;
//import com.niit.Luvbro.model.CartItems;
import com.niit.Luvbro.model.Order;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.OrderItems;

public class OrderItemsTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	OrderItems orderitems = (OrderItems)context.getBean("orderItems");
	Order order = (Order)context.getBean("order");
	
	OrderItemsDao orderitemsDao =(OrderItemsDao) context.getBean("orderitemsDao"); //new UserDaoImpl();
	@SuppressWarnings("unused")
	OrderDao orderDao =(OrderDao) context.getBean("orderDao"); //new UserDaoImpl();
	
	order.setO_id("92");
//	orderitems.setOrder(order);

	
	orderitems.setOrderitem_id("28");
	orderitems.setP_id("1");
	orderitems.setOrder(order);
	

	if(orderitemsDao.saveOrUpdate(orderitems))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	orderitems = (OrderItems)orderitemsDao.getOrderItems("28");
	if(orderitems != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}
//		if(orderitemsDao.delete(orderitems))
//		{
//			System.out.println("id deleted successfull");
//		}
//		else
//		{
//			System.out.println("sorry");
//		
//		}
	context.close();
	  
	}
}

