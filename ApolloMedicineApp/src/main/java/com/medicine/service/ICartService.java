package com.medicine.service;

import java.util.List;

import com.medicine.exceptions.MedicineNotFoundException;
import com.medicine.model.Cart;

public interface ICartService {
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id and store it in cart
	 *@param name the name of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Cart> getCart(String name) throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id from the cart
	 */
	void getShowCart();
}
