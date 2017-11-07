package com.niit.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.models.Category;

public class CategoryTestcase {
	@Autowired
	static AnnotationConfigApplicationContext  config;
	@Autowired
	static Category category;
	@Autowired
static	CategoryDao categorydao;
	
	@BeforeClass
	public static void setConfig(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.niit");
		config.refresh();
		category =  (Category)config.getBean("category");
		categorydao=  (CategoryDao)config.getBean("categoryDao");
	
	}
	@Test
	public void checkCategory(){
		List<Category> catlist = categorydao.getAllCategory();
		
		Assert.assertEquals(3, catlist.size());
	}

	//@Test
	public void test() {
		
		category.setName("Lipstick");
		category.setDescription("Fresh New Lipsticks");
		boolean saved=categorydao.save(category);
		
		
		Assert.assertEquals(true, saved);
		
	}
	
	@Test
	public void test1()
	{
		//category.setCatId(1);
		category.setName("Lipstick");
	    category.setDescription("updated Lipstick");
	    boolean updated=categorydao.update(category);
	    Assert.assertEquals(true, updated);
		 
	}   

}
