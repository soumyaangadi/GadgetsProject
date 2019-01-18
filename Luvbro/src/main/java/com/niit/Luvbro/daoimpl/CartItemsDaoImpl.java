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

import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.CartItems;
//import com.niit.Luvbro.model.Product;

@Repository("cartitemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public CartItemsDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(CartItems cartitems) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(CartItems cartitems)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(cartitems);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
//
//	
//	public CartItems getCartItems(int id) 
//	{
//		if(cartItems.getC_id()==id)
//			return carditems;
//		return null;
//	}
//
//	
//	public List<CartItems> list() {
//		return null;
//	}

	@Override
	public CartItems getCartItems(String id) {
		String q1="from CartItems where c_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<CartItems> list() {
		@SuppressWarnings("unchecked")
		List<CartItems> cartitemss = (List<CartItems>) sessionFactory.getCurrentSession().createCriteria(CartItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cartitemss;
	}
	
	@Transactional
	public List<CartItems> getlist(String cart_Id)
	{
		String Sq1="From CartItems where cart_Id='"+cart_Id+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(Sq1);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>)q1.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
		
	}

	@Override
	public CartItems getlistall(String cart_Id, String pro) {
		String sql= "from CartItems where cart_d='" +cart_Id+ "'and p_id ='" +pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	@Override
	public List<CartItems> getlistbyproId(String p_id) {
		String Sq= "From CartItems  where p_id='"+p_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list;
		}
	}

}
