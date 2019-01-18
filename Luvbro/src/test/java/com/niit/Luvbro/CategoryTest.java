package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.CategoryDao;
//import com.niit.Luvbro.daoimpl.CategoryDaoImpl;
import com.niit.Luvbro.model.Category;

public class CategoryTest 
{
	public static void main(String a[])
	{
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	  context.scan("com.niit.Luvbro.*");
	  context.refresh();

	  Category category =(Category)context.getBean("category");
	  CategoryDao categoryDao =(CategoryDao)context.getBean("categoryDao");
	  
		category.setC_id("10");
		category.setC_name("Choclates");
		category.setSubC_name("Diary Milk");
		if(categoryDao.saveOrUpdate(category))
			{
				System.out.println("save is successfull");
			}
			else
			{
				System.out.println("sorry");
			}
		  category = (Category)categoryDao.getCategory("10");
			if(category != null)
			{
				System.out.println("id found successfully");
			}
			else
			{
				System.out.println("id not found");
			}
//			if(categoryDao.delete(category))
//			{
//				System.out.println("Object deleted Sucessfully");
//			}
//			else
//			{
//				System.out.println("sorry");
//			
//			}
		context.close();
		
		}

}
