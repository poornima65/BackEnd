package com.niit.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table
public class Product implements Serializable {
	 @Id
	 // Automatically Assigns Value to id using Sequence
	 @SequenceGenerator(name = "catseq", sequenceName = "catseq")
	 @GeneratedValue(strategy=GenerationType.AUTO,generator = "catseq")
    int productid;
 @Column
 String productName;
 
@Column
@Min(value=1)
 double qty;
 @Column
 @Min(value=1)
 double price;
 @Column
 @Size(min=5)
 @NotBlank
 String description;
 
 @OneToOne
 @JoinColumn(name="catId")
 Category category;
@OneToOne
 @JoinColumn(name="supId")
 Supplier supplier;
 @Column
 String imagePath;
 
 @Transient 
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
public int getProductid() {
  return productid;
 }
 public void setProductid(int productid) {
  this.productid = productid;
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