package com.niit.Luvbrofrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Supplier;

@Controller
public class Suppliercontroller
{
	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/supplier")
	public ModelAndView supplier()
	{
		List<Supplier> suppliers=supplierDao.list();
		ModelAndView obj=new ModelAndView("supplier");
		obj.addObject("supplier", new Supplier());
		obj.addObject("suppliers",suppliers);
		return obj;
	}

	@RequestMapping(value="/Add_supplier", method=RequestMethod.POST)
	public ModelAndView category(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView obj = new ModelAndView("redirect:/supplier");
		if(supplierDao.saveOrUpdate(supplier))
		{
			obj.addObject("msg","\t Scessfully Saved the Supplier");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the Supplier Please re-try");
		return obj;
	}
	
	@RequestMapping("/editsupplier/{S_id}")
	public ModelAndView editsupplier(@PathVariable("S_id")String S_id)
	{
		List<Supplier> suppliers=supplierDao.list();
		ModelAndView obj=new ModelAndView("supplier");
		supplier=supplierDao.getSupplier(S_id);
		obj.addObject("suppliers",suppliers);
		obj.addObject("supplier",supplier);
		return obj;
	}
	@RequestMapping("/deletesupplier/{S_id}")
	public ModelAndView deletesupplier(@PathVariable("S_id")String S_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		supplier=supplierDao.getSupplier(S_id);
		if(supplierDao.delete(supplier))
		{
			obj.addObject("msg","Supplier is deleted successfully");
		}
		else
		{
			obj.addObject("msg","Supplier cannot be deleted");
		}
		return obj;
	}
}

