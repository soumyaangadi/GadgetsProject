package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Billing;



public interface BillingDao 
{
	public boolean saveOrUpdate(Billing billing);
	public boolean delete(Billing billing);
	public Billing getBilling(String id);
	public List<Billing> list();
    public Billing get(String U_id);
}
