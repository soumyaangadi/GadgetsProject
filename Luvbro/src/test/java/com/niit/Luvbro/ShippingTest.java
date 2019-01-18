package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.ShippingDao;
import com.niit.Luvbro.model.Pay;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Shipping;

public class ShippingTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	Shipping shipping = (Shipping)context.getBean("shipping");
	ShippingDao shippingDao =(ShippingDao) context.getBean("shippingDao"); //new UserDaoImpl();

	shipping.setS_id("45");
	shipping.setS_houseno("127");
	shipping.setS_email("priyadharshini231298@gmail.com");
	shipping.setS_landmark("postoffice");
	shipping.setS_city("bangalore");
	shipping.setS_state("karnataka");
	shipping.setS_country("India");
	shipping.setS_pincode("560010");
	
	if(shippingDao.saveOrUpdate(shipping))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	shipping = (Shipping)shippingDao.getShipping("45");
	if(shipping != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}	
//	if(shippingDao.delete(shipping))
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

