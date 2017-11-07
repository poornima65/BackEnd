package com.niit.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.niit.models.Product;
public interface ProductDao {
 public List < Product > getAllProduct();
 public List < Product > getByCategoryId(int catid);
 public List<Product> searchByProductName(String pname);
 public boolean save(Product p);
 public boolean deleteById(int id);
 public boolean update(Product p);
 public Product getById(int id);
 public void storeFile(Product p, HttpServletRequest request);
}