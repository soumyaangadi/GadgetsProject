package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.CardDao;
//import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Card;
import com.niit.Luvbro.model.Category;

public class CardTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.*");
		  context.refresh();
	
	Card card = (Card)context.getBean("card");
	
	card.setCard_Id("76");
	card.setCard_No(123456);
	card.setCard_HolderName("Priyadhharshini");
	card.setCard_expdate(12);
	card.setCard_expmnt(5);
	card.setCard_expyear(2018);
	
	CardDao cardDao =(CardDao) context.getBean("cardDao"); //new UserDaoImpl();
	if(cardDao.saveOrUpdate(card))
	{
		System.out.println("save is successfull");
	}
	else
	{
		System.out.println("Sorry");
	}
	card = (Card)cardDao.getCard("76");
	if(card != null)
	{
		System.out.println("id found successfully");
	}
	else
	{
		System.out.println("id not found");
	}
//		if(cardDao.delete(card))
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
