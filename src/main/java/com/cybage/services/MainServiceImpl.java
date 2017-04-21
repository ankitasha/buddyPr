package com.cybage.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.dao.MainDao;
import com.cybage.dao.MainDaoImpl;
import com.cybage.model.OrderDetails;
import com.cybage.model.Product;
import com.cybage.model.User;

@Service
@Transactional
public class MainServiceImpl implements MainService
{   
    
	@Autowired
	MainDao dao;

	public List<User> getUser() 
	{

		System.out.println(dao instanceof MainDaoImpl);
		return dao.getUser();
	}

	public List<Product> listProducts() {
		System.out.println("Mainserviceimpl  product list");	
		System.out.println(dao instanceof MainDaoImpl);
		return dao.listProducts();
	}

	@Override
	public OrderDetails addProduct(Product product) {
	   System.out.println("serviceImpl addProduct");
		return dao.addProduct(product);
	}

	@Override
	public OrderDetails confirmOrder(String code,String userid) {
       
		System.out.println("ServiceImpl confirmOrder");
		return dao.orderConfirmation(code,userid);
	}

	@Override
	public Product showProductDetails(String productCode) {
		return dao.showProductDetails(productCode);
	}

	@Override
	public User addUser(String userName,String userPassword) {
		return dao.addUser(userName,userPassword);
	}

	@Override
	public void closeSession(Session session)
	{
	   dao.closeSession(session);	
	}

	@Override
	public List<Product> searchProduct(String code) {
		System.out.println("serviceImple search product");
		return dao.searchProduct(code);
	}

	@Override
	public List<OrderDetails> showOrderHistory(String userid) {
	    System.out.println("ServiceImple ShowOrderHistory");
		return dao.showOrderHistory(userid);
	}
  
	
	
}
