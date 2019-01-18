package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Authentication;

public interface AuthenticationDao 
{
	public boolean saveOrUpdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication getAuthentication(String id);
	public List<Authentication> list();

}
