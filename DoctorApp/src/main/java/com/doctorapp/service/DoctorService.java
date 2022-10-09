package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface DoctorService {
	void addDoctor(Doctor doctor);
	void updateDoctor(int doctorId,double fees) throws DoctorNotFoundException;
	Doctor getById(int doctorId) throws IdNotFoundException;
	void deleteDoctor(int doctorId)throws DoctorNotFoundException;
	List<Doctor> getAllDoctors() throws DoctorNotFoundException;
	List<Doctor> getBySpeciality(String speciality)throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndExp(String speciality,int experience)throws DoctorNotFoundException;
	List<Doctor> getBySpecialityAndFees(String speciality,double fees)throws DoctorNotFoundException;
	List<Doctor> getByAvailailabilty(LocalDateTime startTime)throws DoctorNotFoundException;
	
}
