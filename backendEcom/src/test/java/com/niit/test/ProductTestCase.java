package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.models.Product;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static Product product;
	@Autowired
static	ProductDao productdao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		product =  (Product)config.getBean("product");
		productdao=  (ProductDao)config.getBean("productDao");
	
	}
	@Test
	public void checkproduct(){
	List<Product> catlist = productdao.getAllProduct();
		
		Assert.assertEquals(3, catlist.size());
	}

	//@Test
	public void test() {
		
		product.setProductName("Lipstick");
		product.setDescription("Fresh New Lipsticks");
		boolean saved=productdao.save(product);
		
		
		Assert.assertEquals(true, saved);
		
	}
	
	@Test
	public void test1()
	{
		product.setProductid(1);
		product.setProductName("Lipstick");
	    product.setDescription("updated Lipstick");
	    boolean updated=productdao.update(product);
	    Assert.assertEquals(true, updated);
		 
	}   

}
