package com.medicine.service;

import java.util.List;
import java.util.stream.Collectors;

import com.medicine.dao.IMedicineDao;
import com.medicine.dao.MedicineDaoImpl;
import com.medicine.model.Medicine;
import com.medicineapp.exceptions.IdNotFoundException;
import com.medicineapp.exceptions.MedicineNotFoundException;

public class MedicineServiceImpl implements IMedicineService {
	IMedicineDao medicineDao=new MedicineDaoImpl();
	@Override
	public void addMedicine(Medicine medicine) {
		medicineDao.addMedicine(medicine);
		
	}

	@Override
	public void updateMedicine(int medicineId, double fees) {
		medicineDao.updateMedicine(medicineId, fees);
	}

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

	@Override
	public void deleteMedicine(int medicineId) {
		medicineDao.deleteMedicine(medicineId);
	}

	@Override
	public List<Medicine> getByNameContaining(String name) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByNameContaining(name);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}

	@Override
	public List<Medicine> getByCategory(String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategory(category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}

	@Override
	public List<Medicine> getByNameAndCategory(String name, String category) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByNameAndCategory(name, category);
		
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}

	@Override
	public List<Medicine> getByCategoryAndBrand(String category, String brand) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndBrand(category, brand);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}

	@Override
	public List<Medicine> getByCategoryAndLessCost(String category, double cost) throws MedicineNotFoundException {
		List<Medicine> medicines=medicineDao.findByCategoryAndLessCost(category, cost);
		if(medicines.isEmpty()) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}

	@Override
	public boolean getByNameAndAvailabilty(String name,boolean present) throws MedicineNotFoundException{
		
		boolean medicines=medicineDao.findByNameAndAvailabilty(name,present);
		
		if(!medicines) {
			throw new MedicineNotFoundException("MEDICINE IS NOT FOUND");
		}
		
		return medicines;
	}
}
