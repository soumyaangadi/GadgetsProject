package com.niit.Luvbro.dao;

import java.util.List;

import com.niit.Luvbro.model.Card;

//import java.util.List;

public interface CardDao 
{
	public boolean saveOrUpdate(Card card);
	public boolean delete(Card card);
	public Card getCard(String id);
	public List<Card> list();
	public List<Card> getcardbyuser(String U_id);

}
