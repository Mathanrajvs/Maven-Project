package com.medicine.service;

import java.util.List;

import com.medicine.exceptions.IdNotFoundException;
import com.medicine.exceptions.MedicineNotFoundException;
import com.medicine.model.Cart;
import com.medicine.model.Medicine;
/**
 * Perform Operations between DAO layer and Main layer
 *
 */
public interface IMedicineService {

	/**
	 * Transfer data to DAO layer to add medicine in the database
	 * @param medicine the medicine object class
	 */
	void addMedicine(Medicine medicine);
	/**
	 * Transfer data to DAO layer to Update medicine in the database
	 * @param medicineId the medicine id
	 * @param fees the cost of a medicine
	 */
	void updateMedicine(int medicineId,double fees);
	/**
	 * Transfer data to DAO layer to Find the specific medicine in the database
	 * @param medicineId the medicine id
	 * @throws IdNotFoundException to throw exception 
	 */
	Medicine getById(int medicineId)throws IdNotFoundException;
	/**
	 * Transfer data to DAO layer to  Delete the specific medicine in the database
	 * @param medicineId the medicine id
	 */
	void deleteMedicine(int medicineId);
	/**
	 * Transfer data to DAO layer to Show all medicines starts with name containing
	 * @param name the name of the medicine
	 * @throws MedicineNotFoundException to throw the exception
	 */
	List<Medicine> getByNameContaining(String name)throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show all medicines with specific category
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Medicine> getByCategory(String category) throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific name
	 *@param name the name of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Medicine> getByNameAndCategory(String name, String category) throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific brand
	 *@param brand the brand of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Medicine> getByCategoryAndBrand(String category,String brand)throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific cost
	 *@param cost the cost of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Medicine> getByCategoryAndLessCost(String category,double cost)throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific name and check if it is present or not
	 *@param name the name of the medicine
	 *@param present to check the medicine is available
	 *@throws MedicineNotFoundException to throw the exception
	 */
	boolean getByNameAndAvailabilty(String name,boolean present)throws MedicineNotFoundException;
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id and store it in cart
	 *@param id the id of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 */
	List<Cart> getCart(int id) throws MedicineNotFoundException;
}
