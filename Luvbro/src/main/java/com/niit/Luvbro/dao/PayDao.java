package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Pay;

//import java.util.List;

public interface PayDao 
{
	public boolean saveOrUpdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String id);
	public List<Pay> list();

}
