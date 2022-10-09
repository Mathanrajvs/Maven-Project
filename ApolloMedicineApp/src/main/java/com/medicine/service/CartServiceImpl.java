package com.medicine.service;

import java.util.List;

import com.medicine.dao.CartDaoImpl;
import com.medicine.dao.ICartDao;
import com.medicine.exceptions.MedicineNotFoundException;
import com.medicine.model.Cart;

public class CartServiceImpl implements ICartService{
	ICartDao cartDao=new CartDaoImpl();
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id and store it in cart
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Cart> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Cart> getCart(String name) throws MedicineNotFoundException {
		List<Cart> medicines=cartDao.findCart(name);
//		if(medicines.isEmpty()) {
//			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
//		}
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id from the cart
	 */
	@Override
	public void getShowCart() {
		cartDao.findShowCart();
	}

}
