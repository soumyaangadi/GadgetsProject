package com.niit.Luvbrofrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.model.Product;
@Controller
public class HomeController 
{
	
	@Autowired 
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")	
	public String home()
	{ 
		return "home";
	}
	
//	@RequestMapping("/addproduct")	
//	public String addproduct()
//	{
//		return "Add_Product";
//	}
	
//	@RequestMapping("/addcategory")	
//	public String addcategory()
//	{
//		return "Add_Category";
//	}
	
//	@RequestMapping("/addsupplier")	
//	public String addsupplier()
//	{
//		return "Add_Supplier";
//	}
	
	@RequestMapping("/allproducts")	
	public String allproducts(Model model)
	{
		List<Product> productlist = productDao.list();
		model.addAttribute("productlist", productlist);
		return "All_Products";
	}
	
	@RequestMapping("/watch1des")
	public String watch1des()
	{
		return "watch1des";
	}
	
	@RequestMapping("/watch2des")
	public String watch2des()
	{
		return "watch2des";
	}
	
	@RequestMapping("/watch3des")
	public String watch3des()
	{
		return "watch3des";
	}
	
	@RequestMapping("/watch4des")
	public String watch4des()
	{
		return "watch4des";
	}
//	@RequestMapping("/login")	
//	public String login()
//	{
//		return "login";
//	}
	
//	@RequestMapping("/signup")	
//	public String signup()
//	{
//		return "signup";
//	}
	
}
