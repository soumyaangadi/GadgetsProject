package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.dao.UserDao;
//import com.niit.Luvbro.dao.UserDao;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Billing;
//import com.niit.Luvbro.model.User;
//import com.niit.Luvbro.model.Category;
import com.niit.Luvbro.model.User;

public class BillingTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
		  BillingDao billingDao =(BillingDao) context.getBean("billingDao"); //new UserDaoImpl();
		  Billing billing = (Billing)context.getBean("billing");
		  
		  @SuppressWarnings("unused")
		UserDao userDao =(UserDao) context.getBean("userDao"); //new UserDaoImpl();
		  User user= (User)context.getBean("user");
	
	billing.setB_Id("65");
	billing.setB_Landmark("postoffice");
	billing.setB_Houser_Number("127");
	billing.setB_City("bangalore");
	billing.setB_State("karnataka");
	billing.setB_pincode("560010");
	
	user.setU_id("10");
	
	
	
	if(billingDao.saveOrUpdate(billing))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	 billing = (Billing)billingDao.getBilling("65");
	if(billing != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}
//		if(billingDao.delete(billing))
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
