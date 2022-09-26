package com.doctotapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctotapp.model.Doctor;

public interface DoctorDao {
	void addDoctor(Doctor doctor);
	void updateDoctor(int doctorId,double fees);
	Doctor findById(int doctorId);
	void deleteDoctor(int doctorId);
	List<Doctor> findAllDoctors();
	List<Doctor> findBySpeciality(String speciality);
	List<Doctor> findBySpecialityAndExp(String speciality,int experience);
	List<Doctor> findBySpecialityAndFees(String speciality,double fees);
	List<Doctor> findByAvailailabilty(LocalDateTime startTime);
	
}
