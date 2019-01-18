package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Shipping;

//import java.util.List;

public interface ShippingDao 
{
	public boolean saveOrUpdate(Shipping shipping);
	public boolean delete(Shipping shipping);
	public Shipping getShipping(String id);
	public List<Shipping> list();
	public List<Shipping> getaddbyuser(String U_id);

}
