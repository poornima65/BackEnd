package com.niit.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class Category{
 @Id
 // Automatically Assigns Value to id using Sequence
 @SequenceGenerator(name = "catseq", sequenceName = "catseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "catseq")
    int id;
 
 
 @Column
 @NotBlank
 @Size(min=3,message="category name should be more than 3 characters")
 String name;
 @Column
 @NotBlank
 @Size(min=8)
 String description;
public int getId() {
	return id;
}
public void setId(int id){
	this.id = id;
}
public String getName(){
	return name;
}
public void setName(String name){
	this.name = name;
}
public String getDescription(){
	return description;
}
public void setDescription(String description){
	this.description = description;
}


}