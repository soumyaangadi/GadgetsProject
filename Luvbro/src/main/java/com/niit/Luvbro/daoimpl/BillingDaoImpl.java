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

import com.niit.Luvbro.dao.BillingDao;
//import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.model.Billing;
//import com.niit.Luvbro.model.Product;
//import com.niit.Luvbro.model.Category;

@Repository("billingDao")
@EnableTransactionManagement
@Transactional
public class BillingDaoImpl implements BillingDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public BillingDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Billing billing) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(billing);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Billing billing)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(billing);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
	public Billing getBilling(String id) 
	{
	String q1="from Billing where b_Id='"+id+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<Billing> list=(List<Billing>) w.list();
	if(list==null||list.isEmpty())
	{
		return null;
	}
	return list.get(0);
	}

	
	public List<Billing> list() 
	{
		@SuppressWarnings("unchecked")
		List<Billing> billings = (List<Billing>) sessionFactory.getCurrentSession().createCriteria(Billing.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return billings;
	}

	@Override
	public Billing get(String U_id) {
		String q1 ="from Billing where U_id='"+U_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Billing> list = (List<Billing>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}

