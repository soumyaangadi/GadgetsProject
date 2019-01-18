package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.PayDao;
import com.niit.Luvbro.model.OrderItems;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Pay;

public class PayTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	Pay pay = (Pay)context.getBean("pay");
	PayDao payDao =(PayDao) context.getBean("payDao"); //new UserDaoImpl();

	pay.setPay_id("52");
	pay.setPay_way("paytm");
	pay.setPay_status("paid");

	
	if(payDao.saveOrUpdate(pay))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	pay = (Pay)payDao.getPay("52");
	if(pay != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}	
//	if(payDao.delete(pay))
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

