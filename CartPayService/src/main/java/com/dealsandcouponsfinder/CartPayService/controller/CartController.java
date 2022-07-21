package com.dealsandcouponsfinder.CartPayService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealsandcouponsfinder.CartPayService.model.Cart;
import com.dealsandcouponsfinder.CartPayService.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/addCart")
	public String addCart(@RequestBody Cart cart) {
		cartService.save(cart);
		return "cart added successfully";
	}
	
	@GetMapping("/find/cartId/{cartId}")
	public Optional<Cart> searchCartByCartId(@PathVariable("cartId") String cartId) {
		Optional<Cart> cart = cartService.findByCartId(cartId);
		return cart;
	}
	
	@GetMapping("/find/userId/{userId}")
	public List<Optional<Cart>> searchCartByUserId(@PathVariable("userId") String userId) {
		List<Optional<Cart>> cart2 = cartService.findByUserId(userId);
		return cart2;
	}
	
	@GetMapping("/findall")
	public List<Cart> findCart() {
		return (List<Cart>) cartService.findAll();
	}
	
	@PostMapping("/deleteCart/{id}")
	public String deleteCartById(@PathVariable("id") String id) {
		cartService.deleteById(id);
		return "cart deleted successfully";
	}
	
	@GetMapping("/totalPrice/{userId}")
	    public double getTotalPrice(@PathVariable("userId") String userId) {
	        double result=cartService.getTotalPrice(userId);
	    	return result;
	        }
	
	@PostMapping("/deleteAllCart/{userId}")
	public String deleteAllCart(@PathVariable("userId") String userId) {
		cartService.deleteAllCart(userId);
		return "all carts deleted successfully";
	}
	
	@PutMapping("/updateCart")
	public String updateCart(@RequestBody Cart cart) {
		cartService.save(cart);
		return "cart updated successfully";
	}

}
