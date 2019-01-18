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

import com.niit.Luvbro.dao.OrderDao;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.Order;
//import com.niit.Luvbro.model.Product;

@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public OrderDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Order order) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(order);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Order order)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(order);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}


	@Override
	public Order getOrder(String id) {
		String q1="from Order where o_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list=(List<Order>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Order> list() {
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return orders;
	}

}
