package com.niit.dao;
import java.util.List;

import com.niit.models.Cart;

public interface  CartDao {
 public List <Cart> getCartItem(String username);
 public boolean addCart(Cart cart);
 public boolean deleteCart(Cart cart);
 public boolean updateCart(Cart cart);
 public Cart getCartItem(int cartitemId);
}