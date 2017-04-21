package com.cybage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orderdetails")
public class OrderDetails implements Serializable 
{
private static final long serialVersionUID = -1798070786993154676L;
    
private int orderid;
private String productId;
private Date orderDate;
private String userid;
/*private double productPrice;
*/
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="orderid")
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}

@Column(name="productid")
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
@Temporal(value = TemporalType.DATE)
@Column(name="orderdate")
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderdate) {
	this.orderDate = orderdate;
}

@Column(name="userid")
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public OrderDetails() {
	super();
}
public OrderDetails(String productId, Date orderDate) {
	super();
	this.productId = productId;
	this.orderDate = orderDate;
}
@Override
public String toString() {
	return "OrderDetails [orderid=" + orderid + ", productId=" + productId + ", orderDate=" + orderDate + ", userid="
			+ userid + "]";
}





	
	
}
