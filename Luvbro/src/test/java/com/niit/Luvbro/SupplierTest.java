package com.niit.Luvbro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.model.Shipping;
//import com.niit.Luvbro.daoimpl.ProductDaoImpl;
//import com.niit.Luvbro.daoimpl.SupplierDaoImpl;
import com.niit.Luvbro.model.Supplier;

public class SupplierTest 
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		  context.scan("com.niit.Luvbro.*");
		  context.refresh();
		  Supplier s =(Supplier)context.getBean("supplier");
		s.setS_id("100");
		s.setS_name("Ramya");
		s.setS_num(9483863941l);
		s.setS_product("Dairy Milk");
		SupplierDao supplierDao = (SupplierDao)context.getBean("supplierDao");
		if(supplierDao.saveOrUpdate(s))
		{
			System.out.println("save is successfull");
		}
		else
		{
			System.out.println("sorry");
		}
		
		s = (Supplier)supplierDao.getSupplier("100");
		if(s != null)
		{
			System.out.println("id found successfully");
		}
		else
		{
			System.out.println("id not found");
		}			
//		if(supplierDao.delete(s))
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
