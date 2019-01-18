package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.model.Cart;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.CartItems;


public class CartItemsTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
	
	CartItems cartitems = (CartItems)context.getBean("cartItems");
	CartItemsDao cartitemsDao =(CartItemsDao) context.getBean("cartitemsDao"); //new UserDaoImpl();
	
	Cart cart = (Cart)context.getBean("cart");	
	CartDao cartDao =(CartDao) context.getBean("cartDao"); //new UserDaoImpl();
	
	
	cartitems.setC_id("98");
	cartitems.setPrice(65340);
	
	cart.setCart_Id("87");
	cartitems.setCart(cart);
	
	
	if(cartitemsDao.saveOrUpdate(cartitems))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	cartitems = (CartItems)cartitemsDao.getCartItems("98");
	if(cartitems != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}		
//	if(cartitemsDao.delete(cartitems))
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
