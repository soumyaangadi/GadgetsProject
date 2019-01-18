package com.niit.Luvbro.dao;

import java.util.List;

//import java.util.List;

import com.niit.Luvbro.model.Supplier;

public interface SupplierDao 
{
	public boolean saveOrUpdate(Supplier supplier);
	public boolean delete(Supplier Supplier);
	public Supplier getSupplier(String id);
	public List<Supplier> list();

}
