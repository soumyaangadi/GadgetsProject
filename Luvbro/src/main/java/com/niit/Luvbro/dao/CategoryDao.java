package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Category;

//import java.util.List;

public interface CategoryDao 
{
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
	public Category getCategory(String id);
	public List<Category> list();
	public Category getCategoryp(String id);
}
