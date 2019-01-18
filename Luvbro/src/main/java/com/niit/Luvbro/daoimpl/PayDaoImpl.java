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

import com.niit.Luvbro.dao.PayDao;
import com.niit.Luvbro.model.Order;
import com.niit.Luvbro.model.Pay;
//import com.niit.Luvbro.model.Product;

@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements PayDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public PayDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Pay pay) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(pay);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Pay pay)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(pay);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
//
//	
//	public Pay getPay(int id) 
//	{
//		if(pay.getC_id()==id)
//			return pay;
//		return null;
//	}
//
//	
//	public List<Pay> list() {
//		return null;
//	}

	@Override
	public Pay getPay(String id) {
		String q1="from Pay where pay_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list=(List<Pay>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Pay> list() {
		@SuppressWarnings("unchecked")
		List<Pay> pays = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return pays;
	}

}
