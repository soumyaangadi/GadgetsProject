package com.niit.Luvbrofrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Luvbro.dao.CategoryDao;
import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.model.Category;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Supplier;
import com.niit.Luvbrofrontend.Fileinput.FileInput;



@Controller
public class Productcontroller
{
	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	String path="C:\\Users\\priya darshini K\\workspace\\Luvbrofrontend\\src\\main\\webapp\\resource\\images\\";
	
	@RequestMapping("/product")
	public ModelAndView product()
	{
		List<Product> products=productDao.list();
		List<Supplier> suppliers=supplierDao.list();
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("product");
		obj.addObject("product", new Product());
		obj.addObject("products",products);
		obj.addObject("suppliers",suppliers);
		obj.addObject("categories",categories);
		return obj;
	}
//	@RequestMapping("/supplier")
//	public ModelAndView supplier()
//	{
//		List<Supplier> suppliers=supplierDao.list();
//		ModelAndView obj=new ModelAndView("supplier");
//		obj.addObject("supplier", new Supplier());
//		obj.addObject("suppliers",suppliers);
//		return obj;
//	}
//	@RequestMapping("/category")
//	public ModelAndView category()
//	{
//		List<Category> categories=categoryDao.list();
//		ModelAndView obj=new ModelAndView("category");
//		obj.addObject("category", new Category());
//		obj.addObject("categories",categories);
//		return obj;
//	}

   
	@RequestMapping(value="/Add_product", method=RequestMethod.POST)
	public ModelAndView product(@ModelAttribute("product")Product product)
	{
		ModelAndView obj = new ModelAndView("redirect:/product");
		if(productDao.saveOrUpdate(product))
		{
			FileInput.upload(path, product.getPimg(),product.getP_id()+".jpg");
			obj.addObject("msg","\t Scessfully Saved the Product");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Product Please re-try");
		return obj;
	}
	
	@RequestMapping("/editproduct/{p_id}")
	public ModelAndView editproduct(@PathVariable("p_id")String p_id)
	{
		List<Product> products=productDao.list();
		ModelAndView obj=new ModelAndView("product");
		product=productDao.getProduct(p_id);
		obj.addObject("products",products);
		obj.addObject("product",product);
		return obj;
	}
	@RequestMapping("/deleteproduct/{p_id}")
	public ModelAndView deleteproduct(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		product=productDao.getProduct(p_id);
		if(productDao.delete(product))
		{
			obj.addObject("msg","Product is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Product cannot be deleted");
		}
		return obj;
	}
}

