package com.niit.Luvbro.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Luvbro.dao.AuthenticationDao;
import com.niit.Luvbro.model.Authentication;
@Repository("authenticationDao")
@EnableTransactionManagement
@Transactional
public class AuthenticationDaoImpl implements AuthenticationDao
{
	 @Autowired
	  private SessionFactory sessionFactory ;

		 public AuthenticationDaoImpl(SessionFactory sessionFactory)
		 {
			 this.sessionFactory = sessionFactory;
		 }

		public boolean saveOrUpdate(Authentication  authentication) 
		{
		  try
		  {
		   sessionFactory.getCurrentSession().saveOrUpdate( authentication);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
		}


		public boolean delete(Authentication  authentication)
		{
			try
			  {
			   sessionFactory.getCurrentSession().delete( authentication);
			    return true;
			  }
			  catch(Exception E)
			  {
				  return false;
			  }
		}
		public Authentication getAuthentication(String id) 
		{
		String q1="from  Authentication where b_Id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Authentication> list=(List<Authentication>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
		}

		
		public List<Authentication> list() 
		{
			@SuppressWarnings("unchecked")
			List<Authentication> authentications = (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return authentications;
		}



}
