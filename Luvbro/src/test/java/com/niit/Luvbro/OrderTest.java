package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.dao.OrderDao;
import com.niit.Luvbro.dao.PayDao;
import com.niit.Luvbro.dao.ShippingDao;
import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.model.Billing;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Order;
import com.niit.Luvbro.model.OrderItems;
import com.niit.Luvbro.model.Pay;
import com.niit.Luvbro.model.Shipping;
import com.niit.Luvbro.model.User;

public class OrderTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	Order order = (Order)context.getBean("order");
	OrderDao orderDao =(OrderDao) context.getBean("orderDao"); //new UserDaoImpl();
	
	BillingDao billingDao =(BillingDao) context.getBean("billingDao"); //new UserDaoImpl();
	Billing billing = (Billing)context.getBean("billing");
	
	Shipping shipping = (Shipping)context.getBean("shipping");
	ShippingDao shippingDao =(ShippingDao) context.getBean("shippingDao"); //new UserDaoImpl();
	
	Pay pay = (Pay)context.getBean("pay");
	PayDao payDao =(PayDao) context.getBean("payDao"); //new UserDaoImpl();
	
	User user = (User)context.getBean("user");
	UserDao userDao =(UserDao) context.getBean("userDao");
    
	user.setU_id("10");
	order.setUser(user);
    pay.setPay_id("52");
    order.setPay(pay);
	shipping.setS_id("45");  
	order.setShipping(shipping);
	billing.setB_Id("65");
	order.setBilling(billing);
	order.setO_id("92");
	order.setO_orddate("12/06/2017");
	order.setO_ordtime("06:25:12");
	order.setO_grandtotal(76230);
	
	if(orderDao.saveOrUpdate(order))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	order = (Order)orderDao.getOrder("92");
	if(order != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}
//		if(orderDao.delete(order))
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
