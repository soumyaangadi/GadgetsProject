package com.niit.Luvbro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Luvbro.dao.AuthenticationDao;
import com.niit.Luvbro.dao.BillingDao;
import com.niit.Luvbro.dao.CardDao;
import com.niit.Luvbro.dao.CartDao;
import com.niit.Luvbro.dao.CartItemsDao;
import com.niit.Luvbro.dao.CategoryDao;
import com.niit.Luvbro.dao.OrderDao;
import com.niit.Luvbro.dao.OrderItemsDao;
import com.niit.Luvbro.dao.PayDao;
import com.niit.Luvbro.dao.ProductDao;
import com.niit.Luvbro.dao.ShippingDao;
import com.niit.Luvbro.dao.SupplierDao;
import com.niit.Luvbro.dao.UserDao;
import com.niit.Luvbro.daoimpl.AuthenticationDaoImpl;
import com.niit.Luvbro.daoimpl.BillingDaoImpl;
import com.niit.Luvbro.daoimpl.CardDaoImpl;
import com.niit.Luvbro.daoimpl.CartDaoImpl;
import com.niit.Luvbro.daoimpl.CartItemsDaoImpl;
import com.niit.Luvbro.daoimpl.CategoryDaoImpl;
import com.niit.Luvbro.daoimpl.OrderDaoImpl;
import com.niit.Luvbro.daoimpl.OrderItemsDaoImpl;
import com.niit.Luvbro.daoimpl.PayDaoImpl;
import com.niit.Luvbro.daoimpl.ProductDaoImpl;
import com.niit.Luvbro.daoimpl.ShippingDaoImpl;
import com.niit.Luvbro.daoimpl.SupplierDaoImpl;
import com.niit.Luvbro.daoimpl.UserDaoImpl;
import com.niit.Luvbro.model.Authentication;
import com.niit.Luvbro.model.Billing;
import com.niit.Luvbro.model.Card;
import com.niit.Luvbro.model.Cart;
import com.niit.Luvbro.model.CartItems;
import com.niit.Luvbro.model.Category;
import com.niit.Luvbro.model.Pay;
import com.niit.Luvbro.model.Order;
import com.niit.Luvbro.model.OrderItems;
import com.niit.Luvbro.model.Product;
import com.niit.Luvbro.model.Shipping;
import com.niit.Luvbro.model.Supplier;
import com.niit.Luvbro.model.User;

@Configuration
@ComponentScan("com.niit.Luvbro.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test3");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);

	
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}



   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("authenticationDao")
   	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
   	{
   		return new AuthenticationDaoImpl(sessionFactory);
   	}
     
   	@Autowired
   	@Bean("productDao")
   	public ProductDao getProductDao(SessionFactory sessionFactory) 
   	{
   		return new ProductDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("supplierDao")
   	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
   	{
   		return new SupplierDaoImpl(sessionFactory);
   	}
  
   	@Autowired
   	@Bean("userDao")
   	public UserDao getUserDao(SessionFactory sessionFactory) 
   	{
   		return new UserDaoImpl(sessionFactory);
   	}

	@Autowired
	@Bean("billingDao")
	public BillingDao getbillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}
	
    @Autowired
	@Bean("orderitemsDao")
	public OrderItemsDao getorderitemsDao(SessionFactory sessionFactory) 
    {
    return new OrderItemsDaoImpl(sessionFactory);
	}
    
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory)
	{
		return new CardDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) 
	{
		return new PayDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingDao")
	public ShippingDao getshippingAddressDao(SessionFactory sessionFactory)
	{
		return new ShippingDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getcartDao(SessionFactory sessionFactory) 
	{
		return new CartDaoImpl(sessionFactory);

	}
    @Autowired
	@Bean("orderDao")
	public OrderDao getorderDao(SessionFactory sessionFactory)
    {
	return new OrderDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartItemDao")
	public CartItemsDao getCartItemDao(SessionFactory sessionFactory) 
	{
		return new CartItemsDaoImpl(sessionFactory);
	}
}