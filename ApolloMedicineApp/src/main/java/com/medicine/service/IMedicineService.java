package com.medicine.service;

import java.util.List;

import com.medicine.model.Medicine;
import com.medicineapp.exceptions.IdNotFoundException;
import com.medicineapp.exceptions.MedicineNotFoundException;

public interface IMedicineService {

	
	void addMedicine(Medicine medicine);
	void updateMedicine(int medicineId,double fees);
	Medicine getById(int medicineId)throws IdNotFoundException;
	void deleteMedicine(int medicineId);
	List<Medicine> getByNameContaining(String name)throws MedicineNotFoundException;
	List<Medicine> getByCategory(String category) throws MedicineNotFoundException;
	List<Medicine> getByNameAndCategory(String name, String category) throws MedicineNotFoundException;
	List<Medicine> getByCategoryAndBrand(String category,String brand)throws MedicineNotFoundException;
	List<Medicine> getByCategoryAndLessCost(String category,double cost)throws MedicineNotFoundException;
	boolean getByNameAndAvailabilty(String name,boolean present)throws MedicineNotFoundException;
}
