package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.model.Billing;
import com.niit.Luvbro.model.Cart;
//import com.niit.Luvbro.model.Shipping;
//import com.niit.Luvbro.model.Billing;
//import com.niit.Luvbro.model.Cart;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.User;

public class UserTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	User user = (User)context.getBean("user");
	UserDao userDao =(UserDao) context.getBean("userDao"); //new UserDaoImpl();
    Cart cart = (Cart)context.getBean("cart");
	CartDao cartDao =(CartDao) context.getBean("cartDao"); //new UserDaoImpl();
	BillingDao billingDao =(BillingDao) context.getBean("billingDao"); //new UserDaoImpl();
	Billing billing = (Billing)context.getBean("billing");
	
	cart.setCart_Id("87");
	billing.setB_Id("65");
	user.setCart(cart);
	user.setBilling(billing);
	user.setU_id("10");
	user.setU_name("Priyadharshini");
	user.setU_phoneno(990008919);
	user.setU_password("9900089199");
	user.setU_rptpwd("9900089199");
	user.setU_email_addr("priyadharshini231298@gmail.com");
	
	
	
	if(userDao.saveOrUpdate(user))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	user = (User)userDao.getUser("10");
	if(user != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}			
//	if(userDao.delete(user))
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
