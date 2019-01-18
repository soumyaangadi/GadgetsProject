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

import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.model.Card;
import com.niit.Luvbro.model.Cart;
//import com.niit.Luvbro.model.Product;

@Repository("cartDao")
@EnableTransactionManagement
@Transactional
public class CartDaoImpl implements CartDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public CartDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Cart cart) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(cart);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Cart cart)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(cart);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}

	@Override
	public Cart getCart(String id) {
		String q1="from Cart where cart_Id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Cart> list=(List<Cart>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> carts = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return carts;
	}


}
