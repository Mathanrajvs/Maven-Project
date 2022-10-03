package com.medicine.service;

import java.util.List;

import com.medicine.dao.IMedicineDao;
import com.medicine.dao.MedicineDaoImpl;
import com.medicine.model.Cart;
import com.medicine.model.Medicine;
import com.medicineapp.exceptions.IdNotFoundException;
import com.medicineapp.exceptions.MedicineNotFoundException;
/**
 *Perform operations in Service layer
 * @implSpec IMedicineService the interface
 * @author MathanRajS
 *@version 18.x
 */
public class MedicineServiceImpl implements IMedicineService {
	IMedicineDao medicineDao=new MedicineDaoImpl();
	/**
	 * Transfer data to DAO layer to add medicine in the database
	 * @param medicine the medicine object class
	 * @return void returns nothing
	 * @author MathanRajS
	 */
	@Override
	public void addMedicine(Medicine medicine) {
		medicineDao.addMedicine(medicine);
		
	}
	/**
	 * Transfer data to DAO layer to Update medicine in the database
	 * @param medicineId the medicine id
	 * @param fees the cost of a medicine
	 * @return void return nothing
	 * @author MathanRajS
	 */
	@Override
	public void updateMedicine(int medicineId, double fees) {
		medicineDao.updateMedicine(medicineId, fees);
	}
	/**
	 * Transfer data to DAO layer to Find the specific medicine in the database and if not then throw the exception
	 * @param medicineId the medicine id
	 * @throws IdNotFoundException to throw exception 
	 * @return Medicine return medicine object
	 * @author MathanRajS
	 */
	@Override
	public Medicine getById(int medicineId) throws IdNotFoundException {
		Medicine medicine=medicineDao.findById(medicineId);
		
		if(medicine!=null) {
			return medicine;
		}
		
		else {
			throw new IdNotFoundException("ID IS NOT FOUND");
		}
	}
	/**
	 * Transfer data to DAO layer to  Delete the specific medicine in the database
	 * @param medicineId the medicine id
	 * @return void return nothing
	 * @author MathanRajS
	 */
	@Override
	public void deleteMedicine(int medicineId) {
		medicineDao.deleteMedicine(medicineId);
	}
	/**
	 * Transfer data to DAO layer to Show all medicines starts with name containing and if not then throw the exception
	 * @param name the name of the medicine
	 * @throws MedicineNotFoundException to throw the exception
	 * @return List<Medicine> to list the medicines
	 * @author MathanRajS
	 */
	@Override
	public List<Medicine> getByNameContaining(String name) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByNameContaining(name);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show all medicines with specific category and if not then throw the exception
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategory(String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategory(category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific name and if not then throw the exception
	 *@param name the name of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByNameAndCategory(String name, String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByNameAndCategory(name, category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific brand and if not then throw the exception
	 *@param brand the brand of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategoryAndBrand(String category, String brand) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndBrand(category, brand);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific category and specific cost and if not then throw the exception
	 *@param cost the cost of the medicine
	 *@param category the category of the medicine
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Medicine> getByCategoryAndLessCost(String category, double cost) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndLessCost(category, cost);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific name and check if it is present and if not then throw the exception
	 *@param name the name of the medicine
	 *@param present to check the medicine is available or not
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */

	@Override
	public boolean getByNameAndAvailabilty(String name,boolean present) throws MedicineNotFoundException{
		
		boolean medicines=medicineDao.findByNameAndAvailabilty(name,present);
		
		if(!medicines) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
	/**
	 *Transfer data to DAO layer to Show medicines with specific name or medicine id and store it in cart
	 *@throws MedicineNotFoundException to throw the exception
	 *@return List<Medicine> to list the medicines
	 *@author MathanRajS
	 */
	@Override
	public List<Cart> getCart(int id) throws MedicineNotFoundException {
		List<Cart> medicines=medicineDao.findCart(id);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		return medicines;
	}
}
