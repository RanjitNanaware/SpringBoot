package com.qsp.springboot_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_cart.dto.Cart;
import com.qsp.springboot_cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public Cart saveCart(@RequestBody Cart cart) {
		return cartService.saveCart(cart);
	}
	
//	@GetMapping("/all")
//	public List<Cart> findAllCart() {
//		
//	}
//	
//	@DeleteMapping("/{id}")
//	public Cart deleteCart(@PathVariable int id) {
//		
//	}
	
	@PutMapping("/update")
	public Cart updateCart(@RequestParam int id,@RequestBody Cart cart) {
		return cartService.updateCart(id,cart);
	}
	
}
