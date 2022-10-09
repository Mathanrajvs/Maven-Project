package com.doctorapp.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.text.DateFormatter;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
import com.doctorapp.service.DoctorService;
import com.doctorapp.service.DoctorServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Hospital Platform");
		int choice;
		DoctorService doctorService = new DoctorServiceImpl();
		DoctorService service = new DoctorServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Admin \t 2.Users");
			int switchToAdminOrUser = sc.nextInt();
			switch (switchToAdminOrUser) {
			case 1:
				System.out.println("1.Add Doctor \t 2.Update Doctor \t 3.Find Doctor \t 4.Delete Doctor");
				int switchToPerformOperation = sc.nextInt();
				switch (switchToPerformOperation) {
				case 1:
					System.out.println("Enter the Number of Doctors : ");
					int end = sc.nextInt();
					for (int start = 1; start <= end; start++) {
						System.out.println("Enter the Name : ");
						String name = sc.next();
						sc.nextLine();
						System.out.println("Enter the ID : ");
						int id = sc.nextInt();
						System.out.println("Enter the Specialization : ");
						String specialisation=sc.next().toUpperCase();
						Specialization special=Specialization.valueOf(specialisation);
						switch(special) {
						case CARDIO:specialisation="Cardiology";break;
						case ORTHO:specialisation="Orthopeadician";break;
						case PEADO:specialisation="Pediatrician";break;
						case DIABETIC:specialisation="Diabetician";break;
						case PHYSICIAN:specialisation="General Physician";break;
						}
						System.out.println("Enter the Fees : ");
						Double fees=sc.nextDouble();
						System.out.println("Enter the Experience : ");
						int experience=sc.nextInt();
						

						System.out.println("Enter the YYYY-MM-DD  ");
						String dateStart=sc.next();
						LocalDate dateLocalStart = LocalDate.parse(dateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						System.out.println("Enter the HH:MM:SS  ");
						String timeStart=sc.next();
						LocalTime timeLocalStart = LocalTime.parse(timeStart, DateTimeFormatter.ofPattern("HH:mm:ss"));
						
						
						System.out.println("Enter the YYYY-MM-DD : ");
						String dateEnd=sc.next();
						LocalDate dateLocalEnd = LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						System.out.println("Enter the HH-MM-SS : ");
						String timeEnd=sc.next();
						LocalTime timeLocalEnd = LocalTime.parse(timeEnd, DateTimeFormatter.ofPattern("HH:mm:ss"));


						LocalDateTime startTime = LocalDateTime.of(dateLocalStart,timeLocalStart);
						LocalDateTime endTime = LocalDateTime.of(dateLocalEnd,timeLocalEnd);

						Doctor doctor = new Doctor(name, id, specialisation, fees, experience, startTime, endTime);
						
						service.addDoctor(doctor);
					}
					break;
				case 2:
					System.out.println("Enter the ID : ");
					int idUpdate = sc.nextInt();
					System.out.println("Enter the Fees : ");
					Double fees = sc.nextDouble();
					try {
						doctorService.updateDoctor(idUpdate, fees);
					} catch (DoctorNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("NOT UPDATED");
					}
					break;
				case 3:
					System.out.println("Enter the ID : ");
					int getDoctor = sc.nextInt();
					try {
						if(doctorService.getById(getDoctor)!=null)
						System.out.println(doctorService.getById(getDoctor));
						else {
							throw new IdNotFoundException();
						}
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("ID IS NOT FOUND");
					}
					break;
				case 4:
					System.out.println("Enter the ID : ");
					int getDelete = sc.nextInt();
					try {
						try {
							if(doctorService.getById(getDelete)!=null)
							doctorService.deleteDoctor(getDelete);
							else {
								throw new IdNotFoundException();
							}
						} catch (IdNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("ID IS NOT FOUND");
						}
					} catch (DoctorNotFoundException e) {
					e.printStackTrace();
						System.out.println("NOT DELETED");
					}
					break;
				default:
					System.out.println("WRONG INPUT");
					break;

				}break;
			case 2:
				System.out.println("1.Show All \t 2.Show Speciality \t 3.Show Speciality and Experience \t 4.Show Speciality and Fees \t5.Show Available Time");
				int switchToShowOperation = sc.nextInt();
				switch (switchToShowOperation) {
				case 1:
					List<Doctor> showAllDoctors;
					try {
						showAllDoctors = doctorService.getAllDoctors();
						showAllDoctors.forEach(System.out::println);
					} catch (DoctorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 2:
					System.out.println("Enter the Speciality :\n(\"Orthopeadician\"),"
							+ "(\"Pediatrician\"),"
							+ "(\"Diabetician\"),"
							+ "(\"Cardiology\"),"
							+ "(\"General Physician\") ");
					String showSpeciality = sc.next();
					List<Doctor> showSpecialityDoctors;
					try {
						showSpecialityDoctors = doctorService.getBySpeciality(showSpeciality);
						if(showSpecialityDoctors.isEmpty()) {
							throw new DoctorNotFoundException();
						}
						showSpecialityDoctors.forEach(System.out::println);
					} catch (DoctorNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("SPECIALITY IS NOT FOUND");
					}
					
					break;
				case 3:
					System.out.println("Enter the Speciality : ");
					String showSpecialityDoctor = sc.next();
					System.out.println("Enter the Experience : ");
					int showExperience= sc.nextInt();
					List<Doctor> showSpecialityDoctorsAndExperience;
					try {
						showSpecialityDoctorsAndExperience = doctorService.getBySpecialityAndExp(showSpecialityDoctor, showExperience);
						showSpecialityDoctorsAndExperience.forEach(System.out::println);
					} catch (DoctorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 4:
					System.out.println("Enter the Speciality : ");
					String showSpecialityAndFees = sc.next();
					System.out.println("Enter the Fees : ");
					double showFees= sc.nextInt();
					List<Doctor> showSpecialityDoctorsAndFees;
					try {
						showSpecialityDoctorsAndFees = doctorService.getBySpecialityAndFees(showSpecialityAndFees, showFees);
					
						showSpecialityDoctorsAndFees.forEach(System.out::println);
						} catch (DoctorNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
					break;
				case 5:
					System.out.println("Enter the YYYY-MM-DD  ");
					String dateStart=sc.next();
					LocalDate dateLocalStart = LocalDate.parse(dateStart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					System.out.println("Enter the HH:MM:SS  ");
					String timeStart=sc.next();
					LocalTime timeLocalStart = LocalTime.parse(timeStart, DateTimeFormatter.ofPattern("HH:mm:ss"));
					
					
					LocalDateTime showDateTimeInput=LocalDateTime.of(dateLocalStart,timeLocalStart);
					List<Doctor> showDateTime;
					try {
						showDateTime = doctorService.getByAvailailabilty(showDateTimeInput);
						showDateTime.forEach(System.out::println);
					} catch (DoctorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				default:
					System.out.println("WRONG INPUT");
					break;

				}
				

			}
			System.out.println("Press 1 to Continue....");
			choice = sc.nextInt();
		} while (1 == choice);

	}

}
