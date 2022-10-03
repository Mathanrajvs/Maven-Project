package com.medicine.dao;

import java.util.List;

import com.medicine.model.Cart;
import com.medicine.model.Medicine;

public interface IMedicineDao {
	/**
	 * To add medicine in the database
	 * @param medicine the medicine object class
	 */
	void addMedicine(Medicine medicine);
	/**
	 * To Update medicine in the database
	 * @param medicineId the medicine id
	 * @param fees the cost of a medicine
	 */
	void updateMedicine(int medicineId,double fees);
	/**
	 * To Find the specific medicine in the database
	 * @param medicineId the medicine id
	 */
	Medicine findById(int medicineId);
	/**
	 *To Delete the specific medicine in the database
	 * @param medicineId the medicine id
	 */
	void deleteMedicine(int medicineId);
	/**
	 *Show all medicines starts with name containing
	 * @param name the name of the medicine
	 */
	List<Medicine> findByNameContaining(String name);
	/**
	 *Show all medicines with specific category
	 *@param category the category of the medicine
	 */
	List<Medicine> findByCategory(String category);
	/**
	 *Show medicines with specific category and specific name
	 *@param name the name of the medicine
	 *@param category the category of the medicine
	 */
	List<Medicine> findByNameAndCategory(String name, String category);
	/**
	 *Show medicines with specific category and specific brand
	 *@param brand the brand of the medicine
	 *@param category the category of the medicine
	 */
	List<Medicine> findByCategoryAndBrand(String category,String brand);
	/**
	 *Show medicines with specific category and specific cost
	 *@param cost the cost of the medicine
	 *@param category the category of the medicine
	 */
	List<Medicine> findByCategoryAndLessCost(String category,double cost);
	/**
	 *Show medicines with specific name and check if it is present or not
	 *@param name the name of the medicine
	 *@param present to check the medicine is available
	 */
	boolean findByNameAndAvailabilty(String name,boolean present);
	/**
	 *Show medicines with specific name or medicine id and add it to cart
	 *@param name the name of the medicine
	 */
	List<Cart> findCart(int id);
	
	
}
