package com.niit.Luvbro.dao;
import java.util.List;

import com.niit.Luvbro.model.Product;

//import java.util.List;

public interface ProductDao
{
	public boolean saveOrUpdate(Product product);
	public boolean delete(Product product);
	public Product getProduct(String id);
	public List<Product> list();
	public List<Product> getproductC(String id);
	public List<Product> getproductPro(String Name);

}

