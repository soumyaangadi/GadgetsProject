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

import com.niit.Luvbro.dao.CategoryDao;
import com.niit.Luvbro.model.Category;
//import com.niit.Luvbro.model.Product;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional
public class CategoryDaoImpl implements CategoryDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public CategoryDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveOrUpdate(Category category) 
	{
	  try
	  {
	   sessionFactory.getCurrentSession().saveOrUpdate(category);
	    return true;
	  }
	  catch(Exception E)
	  {
		  return false;
	  }
	}


	public boolean delete(Category category)
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(category);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}
//
//	
	public Category getCategory(String id) 
	{
	String q1="from Category where C_id='"+id+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<Category> list=(List<Category>) w.list();
	if(list==null||list.isEmpty())
	{
		return null;
	}
	return list.get(0);
	}

	
	public List<Category> list() 
	{
		@SuppressWarnings("unchecked")
		List<Category> categorys = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return categorys;
	}

	@Override
	public Category getCategoryp(String id) {
		String q1 = "from Product where C_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
	}

}
