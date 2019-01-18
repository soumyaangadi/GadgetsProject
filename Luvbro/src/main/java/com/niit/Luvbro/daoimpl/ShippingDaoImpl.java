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

import com.niit.Luvbro.dao.ShippingDao;
//import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Shipping;
//import com.niit.Luvbro.model.Product;

@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImpl implements ShippingDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public ShippingDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Shipping shipping) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(shipping);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Shipping shipping)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(shipping);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}


	@Override
	public Shipping getShipping(String id) {
		String q1="from Shipping where s_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Shipping> list() {
		@SuppressWarnings("unchecked")
		List<Shipping> shippings = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return shippings;
	}

	@Override
	public List<Shipping> getaddbyuser(String U_id) {
		String q1 ="from Shipping where U_id='"+U_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Shipping> list = (List<Shipping>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

}
