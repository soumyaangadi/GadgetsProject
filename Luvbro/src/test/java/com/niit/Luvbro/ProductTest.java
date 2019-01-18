package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Luvbro.dao.CategoryDao;
import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.model.Category;
import com.niit.Luvbro.model.Pay;
//import com.niit.Luvbro.daoimpl.ProductDaoImpl;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Supplier;

public class ProductTest 
{
	public static void main(String a[])
	{
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();

		Product product = (Product)context.getBean("product");
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		Category category =(Category)context.getBean("category");
		  CategoryDao categoryDao =(CategoryDao)context.getBean("categoryDao");
		  Supplier s =(Supplier)context.getBean("supplier");
		  SupplierDao supplierDao = (SupplierDao)context.getBean("supplierDao");
          s.setS_id("100");
		  category.setC_id("10");
		  product.setCategory(category);
		  product.setSupplier(s);
	
		product.setP_id("1");
		product.setP_name("Dairymilk");
		product.setP_q(23);
		product.setP_c(50.00f);
		product.setDes("choclate that makes us feel that we are in heaven");
		
		if(productDao.saveOrUpdate(product))
		{
			System.out.println("save is successfull");
		}
		else
		{
			System.out.println("sorry");
		}
		
		product = (Product)productDao.getProduct("1");
		if(product != null)
		{
			System.out.println("id found successfully");
		}
		else
		{
			System.out.println("id not found");
		}	
//		if(productDao.delete(product))
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
