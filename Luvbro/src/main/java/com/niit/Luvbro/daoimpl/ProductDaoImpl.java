package com.niit.Luvbro.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
//import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Luvbro.dao.ProductDao;
//
import com.niit.Luvbro.model.Pay;
import com.niit.Luvbro.model.Product;

@Repository("productDao")
@EnableTransactionManagement
@Transactional
public  class ProductDaoImpl implements ProductDao 
{
	Product product=null;
	SessionFactory sessionFactory;
 
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveOrUpdate(Product product) 
	{
		try
		  {
		   sessionFactory.getCurrentSession().saveOrUpdate(product);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}

	
	public boolean delete(Product product) 
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(product);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}


	@Override
	public Product getProduct(String id) {
		String q1="from Product where p_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return products;
	}

	@Override
	public List<Product> getproductC(String id) {
		String q1 = "from Product where C_id='"+id+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
	}

	@Override
	public List<Product> getproductPro(String Name) {
		String q1 = "from Product where p_name='"+Name+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
	}

	



}
