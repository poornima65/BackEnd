package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.Product;

@Repository("productDAO")

@Transactional
public class ProductDaoImpl implements ProductDao {
 @Autowired
 SessionFactory sessionFactory;

 @Override
 public List < Product > getAllProduct() {
  Session session = sessionFactory.openSession();
  Query query = session.createQuery("from Product"); // HQL is used here
               // not SQL
  List < Product > productlist = query.list();
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

}

