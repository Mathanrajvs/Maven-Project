package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import java.util.stream.Collectors;

import com.doctorapp.dao.*;
import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements DoctorService {
	DoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {
		doctorDao.addDoctor(doctor);

	}

	@Override
	public void updateDoctor(int doctorId, double fees) throws DoctorNotFoundException{
	doctorDao.updateDoctor(doctorId, fees);
	}

	@Override
	public Doctor getById(int doctorId) throws IdNotFoundException {

		return doctorDao.findById(doctorId);
	}

	@Override
	public void deleteDoctor(int doctorId) throws DoctorNotFoundException {
		doctorDao.deleteDoctor(doctorId);

	}

	@Override
	public List<Doctor> getAllDoctors()throws DoctorNotFoundException {
		List<Doctor> doctors=doctorDao.findAllDoctors();
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("DOCTORS ARE NOT FOUND");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException{
		List<Doctor> doctors=doctorDao.findBySpeciality(speciality);
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("SPECIALITY IS NOT FOUND");
		}
		
		
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience)throws DoctorNotFoundException {
		List<Doctor> doctors=doctorDao.findBySpecialityAndExp(speciality, experience);
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("SPECIALITY AND EXPERIENCED DOCTOR IS NOT FOUND");
		}
		
		
		return doctors;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException{
		List<Doctor> doctors=doctorDao.findBySpecialityAndFees(speciality, fees);
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("SPECIALITY AND FEES IS NOT FOUND");
		}
		return doctors;
	}

	@Override
	public List<Doctor> getByAvailailabilty(LocalDateTime startTime)throws DoctorNotFoundException {
		List<Doctor> doctors=doctorDao.findByAvailailabilty(startTime);
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("DOCTOR IS NOT AVAILABLE");
		}
		return doctors;
	}

}
