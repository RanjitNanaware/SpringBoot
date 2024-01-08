package com.qsp.springboot_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.springboot_cart.dao.CartDao;
import com.qsp.springboot_cart.dto.Cart;
import com.qsp.springboot_cart.dto.Items;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;

	public Cart saveCart(Cart cart) {
		List<Items> items = cart.getItems();
		double total_price = 0;
		for (Items item : items) {
			total_price += item.getQuantity() + item.getPrice();
		}
		cart.setTotal_price(total_price);
		return cartDao.saveCart(cart);
	}

	public Cart updateCart(int id, Cart cart) {
		Cart dbcart = cartDao.findById(id);
		if (dbcart != null) {
			cart.setId(id);
			List<Items> dbitems = dbcart.getItems();
			List<Items> items = cart.getItems();
			for (int i = 0; i < dbitems.size(); i++) {
				items.get(i).setId(dbitems.get(i).getId());
			}
			cart.setItems(items);
			double total_price = 0;
			for (Items item : items) {
				total_price += item.getQuantity() + item.getPrice();
			}
			cart.setTotal_price(total_price);
			
			return cartDao.updateCart(id, cart);
			
		} else {
			return null;
		}
	}

}
