package com.cybage.services;

import java.util.List;

import org.hibernate.Session;

import com.cybage.model.OrderDetails;
import com.cybage.model.Product;
import com.cybage.model.User;

public interface MainService 
{
	List<User> getUser();
	List<Product> listProducts();
	List<Product> searchProduct(String code);
	OrderDetails addProduct(Product product);
	OrderDetails confirmOrder(String code,String userid);
	Product showProductDetails(String productCode);
    User addUser(String userName,String userPassword);
    void closeSession(Session session);
    public List<OrderDetails> showOrderHistory(String userid) ;

}
