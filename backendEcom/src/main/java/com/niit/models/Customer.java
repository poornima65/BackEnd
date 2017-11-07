package com.niit.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Customer{
 @Id
 // Automatically Assigns Value to id using Sequence
 @SequenceGenerator(name = "cusseq", sequenceName = "cusseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "cusseq")
    int custId;

@Column
 @NotBlank
 @Size(min=3,message="customer name should be more than 3 characters")
 String name;
 @Column
 @NotBlank
 @Size(min=8)
 String address;
 
 @NotBlank
 String email;
 @NotBlank
 @Size(min=5)
String password;
 
 @NotBlank
 @Transient
String confirmPassword;
 

 @Pattern(regexp="\\d{10}")
 String phone;
 
String role;
 
 
 public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}


public int getCustId() {
	return custId;
}


public void setCustId(int custId) {
	this.custId = custId;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getConfirmPassword() {
	return confirmPassword;
}


public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}



}