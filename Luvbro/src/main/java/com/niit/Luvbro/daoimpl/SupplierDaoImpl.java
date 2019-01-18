package com.niit.Luvbro.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.model.Shipping;
import com.niit.Luvbro.model.Supplier;

@Repository("supplierDao")
@EnableTransactionManagement
@Transactional
public class SupplierDaoImpl implements SupplierDao
{
  
	Supplier supplier = null;
    SessionFactory sessionFactory;
     
    public SupplierDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory = sessionFactory;
    }
	
	public boolean saveOrUpdate(Supplier supplier) 
	{
		try
		  {
		   sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}

	
	public boolean delete(Supplier supplier) 
	{
		try
		  {
		   sessionFactory.getCurrentSession().delete(supplier);
		    return true;
		  }
		  catch(Exception E)
		  {
			  return false;
		  }
	}

	
//	public Supplier getSupplier(String id)
//	{
//		if(supplier.getS_id()==id)
//			return supplier;
//		return null;
//	}

	
	
	@Override
	public Supplier getSupplier(String id) {
		String q1="from Supplier where S_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Supplier> list=(List<Supplier>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

@Override
public List<Supplier> list() {
	@SuppressWarnings("unchecked")
	List<Supplier> suppliers = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
	return suppliers;
}

}
