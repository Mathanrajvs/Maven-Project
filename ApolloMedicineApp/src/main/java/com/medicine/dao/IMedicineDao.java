package com.medicine.dao;

import java.util.List;

import com.medicine.model.Medicine;

public interface IMedicineDao {
	void addMedicine(Medicine medicine);
	void updateMedicine(int medicineId,double fees);
	Medicine findById(int medicineId);
	void deleteMedicine(int medicineId);
	List<Medicine> findByNameContaining(String name);
	List<Medicine> findByCategory(String category);
	List<Medicine> findByNameAndCategory(String name, String category);
	List<Medicine> findByCategoryAndBrand(String category,String brand);
	List<Medicine> findByCategoryAndLessCost(String category,double cost);
	boolean findByNameAndAvailabilty(String name,boolean present);
	
}
