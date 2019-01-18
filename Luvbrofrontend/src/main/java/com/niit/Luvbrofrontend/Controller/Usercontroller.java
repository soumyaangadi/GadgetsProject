package com.niit.Luvbrofrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.model.User;


@Controller
public class Usercontroller
{
	@Autowired
	User user;

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/user")
	public ModelAndView user()
	{
		List<User> users=userDao.list();
		ModelAndView obj=new ModelAndView("user");
		obj.addObject("user", new User());
		obj.addObject("users",users);

		return obj;
	}

	@RequestMapping(value="/Add_user", method=RequestMethod.POST)
	public ModelAndView user(@ModelAttribute("user")User user)
	{
		ModelAndView obj = new ModelAndView("redirect:/user");
		if(userDao.saveOrUpdate(user))
		{
			obj.addObject("msg","\t Scessfully Saved the User");
		}
		else
			obj.addObject("msg","\t Sorry!  Failed to Save the User Please re-try");
		return obj;
	}
	
	
}

