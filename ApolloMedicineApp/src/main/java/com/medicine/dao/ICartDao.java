package com.medicine.dao;

import java.util.List;

import com.medicine.model.Cart;

public interface ICartDao {
	/**
	 *Show medicines with specific name or medicine id and add it to cart
	 *@param name the name of the medicine
	 */
	List<Cart> findCart(String name);
	/**
	 *Show medicines with specific name or medicine id from the cart
	 */
	void findShowCart();
}
