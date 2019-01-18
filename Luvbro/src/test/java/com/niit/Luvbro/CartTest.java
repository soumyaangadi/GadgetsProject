package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.model.Card;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.CartItems;

public class CartTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	Cart cart = (Cart)context.getBean("cart");
	
	CartDao cartDao =(CartDao) context.getBean("cartDao"); //new UserDaoImpl();
	
    

	
	cart.setCart_Id("87");
	cart.setTotalitems(5);
	cart.setGrandtotal(12340);
	
	 
	if(cartDao.saveOrUpdate(cart))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	 cart = (Cart)cartDao.getCart("87");
	if(cart != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}	
//		if(cartDao.delete(cart))
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
