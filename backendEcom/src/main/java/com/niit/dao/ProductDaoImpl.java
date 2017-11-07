package com.niit.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.niit.models.Product;

@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDao {
 @Autowired
 SessionFactory sessionFactory;

 @Override
 public List <Product> getAllProduct() {
  Session session = sessionFactory.openSession();
  Query query = session.createQuery("from Product"); // HQL is used here
               // not SQL
  List <Product> productlist = query.list();
  session.close();
  return productlist;
 }
 public List < Product > getByCategoryId(int catid){
	 Session session = sessionFactory.openSession();
	  Query query = session.createQuery("from Product where category.catId="+catid); // HQL is used here
	               // not SQL
	  List <Product> productlist = query.list();
	  session.close();
	  return productlist;
 }
 
 public List<Product> searchByProductName(String pname){
	 Session session = sessionFactory.openSession();
	  Query query = session.createQuery("from Product where productName like '%"+pname+"%'"); // HQL is used here
	  List <Product> productlist = query.list();
	  session.close();
	  return productlist;
 }

 @Override
 public boolean save(Product p) {
  try {
   Session session = sessionFactory.openSession();
   session.save(p);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public boolean deleteById(int id) {
  try {
   Session session = sessionFactory.openSession();
   Product p = (Product) session.get(Product.class, id);
   if (p == null)
    return false;
   session.delete(p);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public boolean update(Product p) {
  try {
   Session session = sessionFactory.openSession();
   session.update(p);
   session.flush();
   session.close();
  } catch (Exception e) {
   return false;
  }

  return true;
 }

 @Override
 public Product getById(int id) {

  Session session = sessionFactory.openSession();
  Product p = (Product) session.get(Product.class, id);
  session.close();
  return p;
 }

 @SuppressWarnings("deprecation")
 public void storeFile(Product p, HttpServletRequest request)
 {
	 System.out.println(request.getRealPath("/"));
	 String path=request.getRealPath("/")+"resources\\images\\"+p.getImagePath();
	 System.out.println(path);
	 MultipartFile file=p.getMultipartfile();
	 
	 
	 if(!file.isEmpty()){
		 try{
			 byte[] bytes =file.getBytes();
			 System.out.println(file.getOriginalFilename());
			 File serverFile=new File(path);
			 serverFile.createNewFile();
			 BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(serverFile));
			 stream.write(bytes);
			 stream.close();
		 
		 }
		 
		 
		 catch(Exception ex)
		 {
			 
			 System.out.println(ex);
			 
		 }
	 }
 }
 
 
 
 
}

