package com.cybage.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.model.OrderDetails;
import com.cybage.model.Product;
import com.cybage.model.User;

@Repository
public class MainDaoImpl implements MainDao
{  
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(MainDaoImpl.class);
	
	@Autowired
	SessionFactory sf;
	
	Date today = Calendar.getInstance().getTime();	
	
	private Session getCurrentSession()
	{
		return sf.getCurrentSession();
	}
	
	
	/**
	 *For getting all users.
	 */
	public List<User> getUser() {
		System.out.println("autowired worked");
		
		
		@SuppressWarnings("unchecked")
		List<User> allUsers = getCurrentSession().createQuery("from User")
				.list();
		
		for(User u:allUsers)
		{logger.info("getting user:"+u);}

		return allUsers;
		
	}
    
/*	for getting product List
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() 
	{	
	System.out.println("MainDao: product list");
	 
	/*List<Product> productlist= new ArrayList<Product>();
	productlist.add(new Product("B001", "Head First PMP", 500.00));
	productlist.add(new Product("C001", "Complete reference", 900.00));
	productlist.add(new Product("D001", "Harry Potter", 200.00));
*/
	List<Product> productlist = getCurrentSession().createQuery("from Product")
								.list();
	System.out.println(productlist);
	
	for(Product p:productlist)
	{
	 logger.info("Showing all products "+p);
	}
	return productlist;
	}
  
	
/*	 Storing product as order
*/	@Override
	public OrderDetails addProduct(Product product)
	{
	System.out.println("MainDao :addProduct");
	  OrderDetails order= (OrderDetails) getCurrentSession().save(product);
   
	  logger.info("adding product as order "+ order);

	  
	  return order ;
	}
    
      
/*	Showing product details
*/	@Override
	public Product showProductDetails(String productCode) 
	{  
	    System.out.println("in show productDetails Main Dao");
		System.out.println("main dao show product details");
		Product product=(Product) getCurrentSession().get(Product.class,productCode);
				/*createQuery("from Product where code="+productCode)*/;
		
		 logger.info("Showing product detail " + product);
		
		return product;
	}

/*   Confirming Order
*/	@Override
	public OrderDetails orderConfirmation(String code,String userid) 
	{ 
	   System.out.println("MainDao confirmOrder"+code);
	   OrderDetails order= new OrderDetails();	   
	   order.setProductId(code);
	   order.setOrderDate(today);
	   order.setUserid(userid);
	   sf.getCurrentSession().save(order);
	   System.out.println("MainDao confirmOrder order is " +order);
	    return order;
	}

	@Override
	public User addUser(String userName,String userPassword) 
	{
	 
	System.out.println("main dao add user"); 
	User newUser= new User();
	newUser.setUserName(userName);
	newUser.setUserPassword(userPassword);
	sf.getCurrentSession().save(newUser);
	 System.out.println("adding new user " + newUser);
	 logger.info("adding new user " + newUser);

	return newUser;   
	}


	@Override
	public void closeSession(Session session) 
	{
	  session.close();	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchProduct(String code)
	{
		 return sf.getCurrentSession().createQuery("from products where Code="+code).list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> showOrderHistory(String userid) 
	{
	List<OrderDetails> orderhistory=  sf.getCurrentSession().createQuery("from orderdetails where userid="+userid).list();
	for(OrderDetails o:orderhistory)
	{
	 logger.info("Showing all products in orderhistory "+o);
	}
	return orderhistory;
	}


	
}
