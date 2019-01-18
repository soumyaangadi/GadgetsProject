package com.niit.Luvbro.daoimpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

//import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Luvbro.dao.CardDao;
import com.niit.Luvbro.model.Billing;
import com.niit.Luvbro.model.Card;
//import com.niit.Luvbro.model.Product;

@Repository("cardDao")
@EnableTransactionManagement
@Transactional
public class CardDaoImpl implements CardDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public CardDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Card card) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(card);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Card card)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(card);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
//
//	
//	public Card getCard(int id) 
//	{
//		if(card.getC_id()==id)
//			return card;
//		return null;
//	}
//
//	
//	public List<Card> list() {
//		return null;
//	}

	@Override
	public Card getCard(String id) 
	{
		String q1="from Card where card_Id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list=(List<Card>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> cards = (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cards;
	}

	@Transactional
	public List<Card> getcardbyuser(String U_id) {
		String q1="from Card where U_id='"+U_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list=(List<Card>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list;
		
	}

}
