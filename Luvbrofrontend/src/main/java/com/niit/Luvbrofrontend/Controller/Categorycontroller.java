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
import com.niit.Luvbro.model.Category;


@Controller
public class Categorycontroller
{
	@Autowired
	Category category;

	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/category")
	public ModelAndView category()
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("category");
		obj.addObject("category", new Category());
		obj.addObject("categories",categories);
		return obj;
	}

	@RequestMapping(value="/Add_category", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("category")Category category)
	{
		ModelAndView obj = new ModelAndView("redirect:/category");
		if(categoryDao.saveOrUpdate(category))
		{
			obj.addObject("msg","\t Scessfully Saved the Category");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Category Please re-try");
		return obj;
	}
	
	@RequestMapping("/editcategory/{C_id}" )
	public ModelAndView editcategory(@PathVariable("C_id")String C_id)
	{
		List<Category> categories=categoryDao.list();
		ModelAndView obj=new ModelAndView("category");
		category=categoryDao.getCategory(C_id);
		obj.addObject("categories",categories);
		obj.addObject("category",category);
		return obj;
	}
	@RequestMapping("/deletecategory/{C_id}")
	public ModelAndView deletecategory(@PathVariable("C_id")String C_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/category");
		category=categoryDao.getCategory(C_id);
		if(categoryDao.delete(category))
		{
			obj.addObject("msg","Category is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Category cannot be deleted");
		}
		return obj;
	}
}

