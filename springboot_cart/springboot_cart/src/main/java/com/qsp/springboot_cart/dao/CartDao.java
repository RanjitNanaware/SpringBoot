package com.qsp.springboot_cart.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_cart.dto.Cart;
import com.qsp.springboot_cart.repo.CartRepo;

@Repository
public class CartDao {

	@Autowired
	private CartRepo cartRepo;

	public Cart saveCart(Cart cart) {
		return cartRepo.save(cart);
	}

	public Cart findById(int id) {
		Optional<Cart> optional = cartRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Cart updateCart(int id, Cart cart) {
		Optional<Cart> optional = cartRepo.findById(id);
		if (optional.isPresent()) {
			cart.setId(id);
			return cartRepo.save(cart);
		} else {
			return null;
		}
	}

}
