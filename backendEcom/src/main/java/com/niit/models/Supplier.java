package com.niit.models;
import java.io.Serializable;

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
public class Supplier implements Serializable {
 @Id
 // Automatically Assigns Value to id using Sequence
 @SequenceGenerator(name = "supseq", sequenceName = "supseq")
 @GeneratedValue(strategy=GenerationType.AUTO,generator = "supseq")
    int supId;
 
 
 @Column
 @NotBlank
 @Size(min=3)
 String name;
 @Column
 @NotBlank
 @Size(min=8)
 String description;

public int getSupId() {
	return supId;
}
public void setSupId(int supId) {
	this.supId = supId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


}