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
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(Queries.INSERTQUERY);
			ps.setString(1, doctor.getDoctName());
			ps.setString(2, doctor.getSpeciality());
			ps.setDouble(3, doctor.getFees());
			ps.setInt(4, doctor.getExperience());
			ps.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			ps.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
			ps.execute();

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void updateDoctor(int doctorId, double fees) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(Queries.UPDATEQUERY);
			ps.setDouble(1, fees);
			ps.setInt(2, doctorId);
			boolean rs = ps.execute();
			if (rs == false)
				System.out.println("UPDATED SUCCESSFULLY");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public Doctor findById(int doctorId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement ps = null;
		Doctor doctor = null;
		try {
			ps = connection.prepareStatement(Queries.FINDQUERY);
			ps.setInt(1, doctorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fees = rs.getDouble(4);
				int experience = rs.getInt(5);
				Timestamp startTime = rs.getTimestamp(6);
				Timestamp endTime = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());

			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(Queries.DELETEQUERY);
			ps.setInt(1, doctorId);
			boolean rs = ps.execute();
			if (rs == false)
				System.out.println("DELETED SUCCESSFULLY");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		Doctor doctor = null;
		try {
			ps = connection.prepareStatement(Queries.SELECTQUERY);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fees = rs.getDouble(4);
				int experience = rs.getInt(5);
				Timestamp startTime = rs.getTimestamp(6);
				Timestamp endTime = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showAllDoctor.add(doctor);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		Doctor doctor;
		try {
			ps = connection.prepareStatement(Queries.SPECIALITYQUERY);
			ps.setString(1, speciality);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fees = rs.getDouble(4);
				int experience = rs.getInt(5);
				Timestamp startTime = rs.getTimestamp(6);
				Timestamp endTime = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpeciality.add(doctor);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		Doctor doctor = null;
		try {
			ps = connection.prepareStatement(Queries.SPECIALITYANDEXPERIENCEQUERY);
			ps.setString(1, speciality);
			ps.setDouble(2, experience);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fees = rs.getDouble(4);
				int experiences = rs.getInt(5);
				Timestamp startTime = rs.getTimestamp(6);
				Timestamp endTime = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fees);
				doctor.setExperience(experiences);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpeciality.add(doctor);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;
		Doctor doctor = null;
		try {
			ps = connection.prepareStatement(Queries.SPECIALITYANDFEESQUERY);
			ps.setString(1, speciality);
			ps.setDouble(2, fees);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fee = rs.getDouble(4);
				int experience = rs.getInt(5);
				Timestamp startTime = rs.getTimestamp(6);
				Timestamp endTime = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fee);
				doctor.setExperience(experience);
				doctor.setStartTime(startTime.toLocalDateTime());
				doctor.setEndTime(endTime.toLocalDateTime());
				showSpecialityAndFees.add(doctor);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
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
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(Queries.TIMEBETWEENQUERY);
			ps.setTimestamp(1, Timestamp.valueOf(startTime));
			//ps.setTimestamp(2, Timestamp.valueOf(startTime));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Doctor doctor = new Doctor();
				String name = rs.getString(1);
				int id = rs.getInt(2);
				String special = rs.getString(3);
				double fee = rs.getDouble(4);
				int experience = rs.getInt(5);
				Timestamp startTimeCheck = rs.getTimestamp(6);
				
				Timestamp endTimeCheck = rs.getTimestamp(7);
				doctor.setDoctName(name);
				doctor.setDoctotId(id);
				doctor.setSpeciality(special);
				doctor.setFees(fee);
				doctor.setExperience(experience);
				doctor.setStartTime(startTimeCheck.toLocalDateTime());
				doctor.setEndTime(endTimeCheck.toLocalDateTime());
				showSpecialityAndFees.add(doctor);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				DbConnection.closeConnection();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return showSpecialityAndFees.stream().sorted().collect(Collectors.toList());
	}

}
