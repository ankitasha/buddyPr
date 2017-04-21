package com.cybage.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product 
{
private String code;
/*private byte[] image;
*/private String name;
private double price;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name="Code")
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

/*@Column(name="Image")
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}*/

@Column(name="Name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@Column(name="Price")
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


public Product(String code, String name, double price) {
	super();
	this.code = code;
	this.name = name;
	this.price = price;
}
public Product() {
	super();
}
public Product(String code) {
	super();
	this.code = code;
}
@Override
public String toString() {
	return "Product [code=" + code + ", " + ", name=" + name + ", price=" + price + "]";
}




}
