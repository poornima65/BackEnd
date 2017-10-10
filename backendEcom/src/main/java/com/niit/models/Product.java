package com.niit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table
public class Product {
	 @Id
	 // Automatically Assigns Value to id using Sequence
	 @SequenceGenerator(name = "catseq", sequenceName = "catseq")
	 @GeneratedValue(strategy=GenerationType.AUTO,generator = "catseq")
    int product_id;
 @Column
 String productName;
 
@Column
 double qty;
 @Column
 double price;
 @Column
 String description;
 
 @ManyToOne
 @JoinColumn(name="id")
 Category category;
 @ManyToOne
 @JoinColumn(name="id")
 Supplier supplier;
 @Column
 String imagePath;
 MultipartFile multipartfile;
 
 
 public MultipartFile getMultipartfile() {
	return multipartfile;
}
public void setMultipartfile(MultipartFile multipartfile) {
	this.multipartfile = multipartfile;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public int getProduct_id() {
  return product_id;
 }
 public void setProduct_id(int product_id) {
  this.product_id = product_id;
 }
 
 public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
 
 

 public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
public double getQty() {
  return qty;
 }
 public void setQty(double qty) {
  this.qty = qty;
 }
 public double getPrice() {
  return price;
 }
 public void setPrice(double price) {
  this.price = price;
 }
 public String getDescription() {
  return description;
 }
 public void setDescription(String description) {
  this.description = description;
 } 
}