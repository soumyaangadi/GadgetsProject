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

import com.niit.Luvbro.dao.OrderItemsDao;
import com.niit.Luvbro.model.Order;
import com.niit.Luvbro.model.OrderItems;
//import com.niit.Luvbro.model.Product;

@Repository("orderitemsDao")
@EnableTransactionManagement
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public OrderItemsDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(OrderItems orderitems) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(orderitems);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(OrderItems orderitems)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(orderitems);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
//
//	
//	public OrderItems getOrderItems(int id) 
//	{
//		if(orderitems.getC_id()==id)
//			return orderitems;
//		return null;
//	}
//
//	
//	public List<OrderItems> list() {
//		return null;
//	}

	@Override
	public OrderItems getOrderItems(String id) {
		String q1="from OrderItems where orderitem_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list=(List<OrderItems>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<OrderItems> list() {
		@SuppressWarnings("unchecked")
		List<OrderItems> ordersitemss = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return ordersitemss;
	}

	@Override
	public List<OrderItems> getOrderItemsbyOrder(String o_id) {
		String q1 ="from OrderItems where o_id='"+o_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

}
