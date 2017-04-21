package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybage.model.OrderDetails;
import com.cybage.model.Product;
import com.cybage.model.User;
import com.cybage.services.MainService;

@Controller
public class MainController 
{ 
 private static final Logger logger = Logger.getLogger(MainController.class);

	
   @Autowired
   MainService service;
   
   
	@RequestMapping("/login")
	public String showMessage1(HttpSession session) 
	{  		
		
		if(session.isNew())
		{
		logger.debug("in login");
		return "login";
		}
		else
		session.invalidate();	
		return "login";
	}

	/**
	 * This is mapped to onclick of Login Button
	 * @param input_user
	 * @param request
	 * @param model
	 * @param session
	 * @return String
	 */
	@RequestMapping("/afterlogin")
	public String afterLogin(@ModelAttribute("User") User input_user,HttpServletRequest request,ModelMap model,HttpSession session)
	{   
		String user_session = (String)session.getAttribute("user_session");
		logger.debug(" in after login..user session"+user_session);
		if(user_session==null)
		{
		String name = input_user.getUserName();
		String pass = input_user.getUserPassword();
		logger.debug("user name:" + name);
		logger.debug("user password:" + pass);

		List<User> allUsers = service.getUser();
		for (User user : allUsers) 
		{
			logger.debug("user......."+user);
			if(user.getUserPassword().equals(pass) && user.getUserName().equals(name))
			{    logger.debug("inside afterlogin if loop");
				 request.getSession().setAttribute("user_session", user.getUserName());
				 return "redirect:homepage";
			}
			else
				{
     				return "/login";}
		 }
		
		}
			return "homepage";
	
	}	
	
	@RequestMapping(value="/homepage")
	public String listProducts(Model model,HttpSession session)
	{   
		List<Product> productlist= service.listProducts();		
		model.addAttribute("productlist",productlist);
		return "homepage";
	}
 
	
	@RequestMapping(value="buy/{code}")
	public String add(@PathVariable String code,ModelMap model ,HttpSession session)
	{ 		
		System.out.println("in buy..."+code);
	  String user_session= (String) session.getAttribute("user_session");
	  Product productdetails=service.showProductDetails(code);
	  System.out.println("productdetails after buy..."+productdetails);
		if(user_session!= null)
		{
	      model.addAttribute("productdetails",productdetails);
	    /*  model.addAttribute("productdetails.name",productdetails.getName());
	      model.addAttribute("productdetails.price",productdetails.getPrice());*/
		  return "productdetails";
		}
		else
		 return "login";
	}
	
	@RequestMapping(value="/buy/confirm/{code}")
	public String showOrder(@PathVariable String code,ModelMap model,HttpSession session)
	{  
	    logger.debug("in show order"+code);
		String user_session= (String) session.getAttribute("user_session");
	    if(user_session!=null)
	    {
		String userid = (String) session.getAttribute("user_session");
	     OrderDetails orders= service.confirmOrder(code,userid);
	     model.addAttribute("orders", orders);
	    logger.debug("Order confirmation"+orders+userid);
     	 return "orderplaced";
	    }
	    else
	    	
		return "redirect:homepage";
	}

	
	
			
	public String orderPlaced(Model model,HttpSession session)
	{
	  logger.debug("in orderplaced....");
	  String user_session= (String) session.getAttribute("user_session");
	    if(user_session!=null)
	    {
   	   return "orderplaced";
	    }
	    else
	    	
		return "homepage";
	}
	
	@RequestMapping(value="/orderhistory")
	public String showOrderHistory(ModelMap model,HttpSession session)
	{
	   String userId= (String) session.getAttribute("user_session");
	   String user_session= (String) session.getAttribute("user_session");
	    
	   if(user_session!=null)
	    {  
		   logger.debug("maincontroller ....in orderhistory "+userId);
		   List<OrderDetails> orderdetails= service.showOrderHistory(userId);
	    	model.addAttribute("orderdetails",orderdetails);
		   return "orderhistory";
	    }
		return "homepage";
	}
	
	@RequestMapping(value="/signup")
	public String signup(Model model,String userName,String password,HttpSession session)
	{   
		System.out.println("in main controller signup");
		String user_session= (String) session.getAttribute("user_session");
	    if(user_session!=null)
	    {
	    	return "login";
	    }
	    else
	    {
		return "registeruser";
	    }
	}
	@RequestMapping(value="/registeruser")
	public String registeruser(ModelMap model,String userName,String userPassword,HttpSession session)
	{   
		System.out.println("in Maincontroller register user");
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
	    service.addUser(userName,userPassword);
	    logger.debug("adding user"+userName+" "+userPassword);
		return "redirect:/homepage";
		}
		else
		{
			return "login";
		}
	}
	
	
	
	
	
	@RequestMapping(value="/thankyou")
	public String end(HttpSession session)
	{
	  String user_session= (String) session.getAttribute("user_session");
      if(user_session!=null)
      {	  
		return "thankyou";
      }
      else
    	 return "homepage";
	}
	
	
	
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{  
		System.out.println("in logout.....");
		session.invalidate();
		return "hompage";
	
	}
	

	}
