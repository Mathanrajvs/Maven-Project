package com.doctotapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.doctotapp.model.Doctor;
import com.doctotapp.util.DbConnection;
import com.doctotapp.util.Queries;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public void addDoctor(Doctor doctor) {

		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.INSERTQUERY);
			preparedstatement.setString(1, doctor.getDoctName());
			preparedstatement.setString(2, doctor.getSpeciality());
			preparedstatement.setDouble(3, doctor.getFees());
			preparedstatement.setInt(4, doctor.getExperience());
			preparedstatement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			preparedstatement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			preparedstatement.execute();

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.UPDATEQUERY);
			preparedstatement.setDouble(1, fees);
			preparedstatement.setInt(2, doctorId);
			boolean result = preparedstatement.execute();
			if (result == false)
				System.out.println("UPDATED SUCCESSFULLY");
			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public Doctor findById(int doctorId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Doctor doctor = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.FINDQUERY);
			preparedstatement.setInt(1, doctorId);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fees = result.getDouble(4);
				int experience = result.getInt(5);
				Timestamp startTime = result.getTimestamp(6);
				Timestamp endTime = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());

			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return doctor;
	}

	@Override
	public void deleteDoctor(int doctorId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.DELETEQUERY);
			preparedstatement.setInt(1, doctorId);
			boolean result = preparedstatement.execute();
			if (result == false)
				System.out.println("DELETED SUCCESSFULLY");
			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Doctor> findAllDoctors() {
		List<Doctor> showAllDoctor = new ArrayList<>();
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Doctor doctor = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.SELECTQUERY);
			preparedstatement.execute();
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fees = result.getDouble(4);
				int experience = result.getInt(5);
				Timestamp startTime = result.getTimestamp(6);
				Timestamp endTime = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showAllDoctor.add(doctor);
			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return showAllDoctor;
	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> showSpeciality = new ArrayList<>();
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Doctor doctor;
		try {
			preparedstatement = connection.prepareStatement(Queries.SPECIALITYQUERY);
			preparedstatement.setString(1, speciality);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fees = result.getDouble(4);
				int experience = result.getInt(5);
				Timestamp startTime = result.getTimestamp(6);
				Timestamp endTime = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpeciality.add(doctor);
			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
//		  return showSpeciality.stream().filter((special)->{ return
//		  special.getSpeciality().equalsIgnoreCase("Cardiology");
//		  }).collect(Collectors.toList());
		 
		return showSpeciality.stream().filter((special)->{ return
				  special.getSpeciality().equalsIgnoreCase(speciality);
				  }).sorted((speciality1, speciality2) -> {
						return speciality1.getSpeciality().compareTo(speciality2.getSpeciality());
					}).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> showSpeciality = new ArrayList<>();
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Doctor doctor = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.SPECIALITYANDEXPERIENCEQUERY);
			preparedstatement.setString(1, speciality);
			preparedstatement.setDouble(2, experience);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fees = result.getDouble(4);
				int experiences = result.getInt(5);
				Timestamp startTime = result.getTimestamp(6);
				Timestamp endTime = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experiences);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpeciality.add(doctor);
			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return showSpeciality.stream().sorted((speciality1, speciality2) -> {
			return speciality1.getSpeciality().compareTo(speciality2.getSpeciality());
		}).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> showSpecialityAndFees = new ArrayList<>();
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		Doctor doctor = null;
		try {
			preparedstatement = connection.prepareStatement(Queries.SPECIALITYANDFEESQUERY);
			preparedstatement.setString(1, speciality);
			preparedstatement.setDouble(2, fees);
			preparedstatement.execute();
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fee = result.getDouble(4);
				int experience = result.getInt(5);
				Timestamp startTime = result.getTimestamp(6);
				Timestamp endTime = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fee);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpecialityAndFees.add(doctor);
			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return showSpecialityAndFees.stream().sorted((speciality1, speciality2) -> {
			return speciality1.getSpeciality().compareTo(speciality2.getSpeciality());
		}).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> findByAvailailabilty(LocalDateTime startTime) {
		List<Doctor> showSpecialityAndFees = new ArrayList<>();
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;

		try {
			preparedstatement = connection.prepareStatement(Queries.TIMEBETWEENQUERY);
			preparedstatement.setTimestamp(1, Timestamp.valueOf(startTime));
			//preparedstatement.setTimestamp(2, Timestamp.valueOf(startTime));
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				Doctor doctor = new Doctor();
				String name = result.getString(1);
				int id = result.getInt(2);
				String special = result.getString(3);
				double fee = result.getDouble(4);
				int experience = result.getInt(5);
				Timestamp startTimeCheck = result.getTimestamp(6);
				
				Timestamp endTimeCheck = result.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fee);
				doctor.setExperience(experience);
				doctor.setStartTime(startTimeCheck.toLocalDateTime());
				doctor.setEndTime(endTimeCheck.toLocalDateTime());
				showSpecialityAndFees.add(doctor);
			}

			preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return showSpecialityAndFees.stream().sorted().collect(Collectors.toList());
	}

}
