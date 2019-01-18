package com.niit.Luvbro.dao;

import java.util.List;

//import com.niit.Luvbro.model.Product;

//import java.util.List;

import com.niit.Luvbro.model.User;

public interface UserDao 
{
	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public User getUser(String id);
	public List<User> list();
	public User getUseremail(String email);
	public User isvalid(String email,String password);

}
