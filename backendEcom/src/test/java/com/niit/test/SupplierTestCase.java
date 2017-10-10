package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.annotations.Check;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.dao.SupplierDaoImpl;
import com.niit.models. Supplier;

public class SupplierTestCase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static  Supplier  supplier;
	@Autowired
static	 SupplierDao  supplierdao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		 supplier =(Supplier)config.getBean("supplier");
		 supplierdao=  (SupplierDao)config.getBean(" supplierDAO");
	
	}
	@Test
	public void Supplier(){
		List<Supplier> catlist =  supplierdao.getAllSupplier();
		
		Assert.assertEquals(3, catlist.size());
	}

	@Test
	public void test() {
		
		 supplier.setName("Lipstick");
		 supplier.setDescription("Fresh New Lipsticks");
		boolean saved= supplierdao.save(supplier);
		
		
		Assert.assertEquals(true, saved);
		
	}
	

}
