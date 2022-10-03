package com.medicine.main;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

import com.medicine.model.Cart;
import com.medicine.model.Category;
import com.medicine.model.Medicine;
import com.medicine.model.User;
import com.medicine.service.*;
import com.medicineapp.exceptions.IdNotFoundException;
import com.medicineapp.exceptions.MedicineNotFoundException;

public class MedicineMain {

	public static void main(String[] args) {
		// IMedicineDao medicineDao = new MedicineDaoImpl();
		IMedicineService medicineService = new MedicineServiceImpl();
		IUserService userService = new UserService();
		int choice;
		try (Scanner sc = new Scanner(System.in)) {
			do {

				System.out.println("1.Admin \t 2.Users");
				int switchToAdminOrUser = sc.nextInt();
				switch (switchToAdminOrUser) {
				case 1:

					System.out.println("1.Register \t2.Login");
					int chooseRegisterOrLoginAdmin = sc.nextInt();
					switch (chooseRegisterOrLoginAdmin) {
					case 1:
						User user = new User();
						System.out.println("Enter the Username : ");
						String userName = sc.next();
						System.out.println("Enter the name : ");
						String name = sc.nextLine();
						sc.next();
						System.out.println("Enter the mobile : ");
						int mobile = sc.nextInt();
						System.out.println("Enter the E-mail : ");
						String email = sc.next();
						System.out.println("Enter the City : ");
						String city = sc.next();
						System.out.println("Enter the UserID : ");
						String userId = sc.next();
						String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
						String password = RandomStringUtils.random(15, characters);
						user.setUsername(userName);
						user.setName(name);
						user.setMobile(mobile);
						user.setEmail(email);
						user.setCity(city);
						user.setUserId(userId);
						user.setPassword(password);
						userService.register(user);
						System.out.println("YEY! YOU HAVE CREATED YOUR ACCOUNT SUCCESSFULLY...");
						System.out.println("Required to Change Password .... ");
						String passwordRegister = sc.next();
						userService.changePassword(userId, passwordRegister);
						break;
					case 2:
						System.out.println("Enter the UserID : ");
						String userIdLogin = sc.next();
						System.out.println("Enter the Password : ");
						String passwordLogin = sc.next();
						int value = userService.login(userIdLogin, passwordLogin);
						if (value == 1)
							System.out.println("Login SuccessFully");
						else {
							System.out.println("Try Again");
							System.exit(0);
						}
						break;
					default:
						System.exit(0);
						break;

					}

					System.out.println("1.Add Medicine \t 2.Update Medicine \t 3.Find Medicine \t 4.Delete Medicine");
					int switchToPerformOperation = sc.nextInt();
					switch (switchToPerformOperation) {
					case 1:
						System.out.println("Enter the Number of Medicines : ");
						int end = sc.nextInt();
						for (int start = 1; start <= end; start++) {
							Medicine medicine = new Medicine();
							System.out.println("Enter the Name : ");
							String name = sc.nextLine();
							sc.nextLine();
							System.out.println("Enter the Medicine ID : ");
							int id = sc.nextInt();
							System.out.println(
									"Enter the Category :\n 1.COVID 2.SKIN 3.AYURVEDIC 4.DIABETIC 5.PAIN 6.COLD 7.CANCER 8.FOODPOISON");
							int category = sc.nextInt();
							String special = Category.values()[category - 1].type;
							System.out.println("Enter the Brand : ");
							String brand = sc.next();
							System.out.println("Enter the Cost : ");
							Double fees = sc.nextDouble();
							System.out.println("Enter the Availability(true/false) : ");
							boolean available = sc.nextBoolean();
							medicine.setMedicineName(name);
							medicine.setMedicineId(id);
							medicine.setCost(fees);
							medicine.setAvailability(available);
							medicine.setBrand(brand);
							medicine.setCategory(special);

							medicineService.addMedicine(medicine);
						}
						break;
					case 2:
						System.out.println("Enter the MedicineID : ");
						int id = sc.nextInt();
						System.out.println("Enter the Cost : ");
						Double fees = sc.nextDouble();

						medicineService.updateMedicine(id, fees);

						break;
					case 3:
						System.out.println("Enter the MedicineID : ");
						int getId = sc.nextInt();

						try {
							Medicine medicineFind = medicineService.getById(getId);
							if (medicineFind != null)
								System.out.println(medicineFind);
							else {
								throw new IdNotFoundException();
							}
						} catch (IdNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("ID IS NOT FOUND");
							System.exit(0);
						}
						break;
					case 4:
						System.out.println("Enter the ID : ");
						int getDelete = sc.nextInt();

						// if (medicineService.getById(getDelete) != null)
						medicineService.deleteMedicine(getDelete);

						break;
					default:
						System.out.println("WRONG INPUT");
						break;

					}
					break;
				case 2:

					System.out.println("1.Register \t2.Login");
					int chooseRegisterOrLogin = sc.nextInt();
					switch (chooseRegisterOrLogin) {
					case 1:
						User user = new User();
						System.out.println("Enter the Username : ");
						String userName = sc.next();
						System.out.println("Enter the name : ");
						String name = sc.nextLine();
						sc.next();
						System.out.println("Enter the mobile : ");
						int mobile = sc.nextInt();
						System.out.println("Enter the E-mail : ");
						String email = sc.next();
						System.out.println("Enter the City : ");
						String city = sc.next();
						System.out.println("Enter the UserID : ");
						String userId = sc.next();
						String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
						String password = RandomStringUtils.random(15, characters);
						user.setUsername(userName);
						user.setName(name);
						user.setMobile(mobile);
						user.setEmail(email);
						user.setCity(city);
						user.setUserId(userId);
						user.setPassword(password);
						userService.register(user);
						System.out.println("YEY! YOU HAVE CREATED YOUR ACCOUNT SUCCESSFULLY...");
						System.out.println("Required to Change Password .... ");
						String passwordRegister = sc.next();
						String changed = userService.changePassword(userId, passwordRegister);
						System.out.println(changed);
						break;
					case 2:
						System.out.println("Enter the UserID : ");
						String userIdLogin = sc.next();
						System.out.println("Enter the Password : ");
						String passwordLogin = sc.next();
						int value = userService.login(userIdLogin, passwordLogin);
						if (value == 1)
							System.out.println("Login SuccessFully");
						else {
							System.out.println("Try Again");
							System.exit(0);
						}
						break;
					default:
						System.exit(0);
						break;

					}

					System.out.println(
							"1.Show Name \t 2.Show Category \t 3.Show Name and Category \t 4.Show Category and Brand \t5.Show Category and Cost \t6.Check Available Medicine \t7.Add to Cart");
					int switchToShowOperation = sc.nextInt();
					sc.nextLine();
					switch (switchToShowOperation) {
					case 1:
						List<Medicine> showAllMedicine;
						try {
							System.out.println("Enter the Name :");
							String name = sc.next();
							showAllMedicine = medicineService.getByNameContaining(name);
							showAllMedicine.forEach(System.out::println);
						} catch (MedicineNotFoundException e) {
							System.out.println(e.getMessage());
							System.exit(0);
						}

						break;
					case 2:
						System.out.println(
								"Enter the Category Number :\n 1.COVID 2.SKIN 3.AYURVEDIC 4.DIABETIC 5.PAIN 6.COLD 7.CANCER 8.FOODPOISON");
						int category = sc.nextInt();
						sc.nextLine();
						String special = Category.values()[category - 1].type;
						List<Medicine> showMedicineCategory;
						try {
							showMedicineCategory = medicineService.getByCategory(special);
							if (showMedicineCategory.isEmpty()) {
								throw new MedicineNotFoundException();
							}
							showMedicineCategory.forEach(System.out::println);
						} catch (MedicineNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("SPECIALITY IS NOT FOUND");
							System.exit(0);
						}

						break;
					case 3:
						System.out.println("Enter the Name :");
						String name = sc.next();
						sc.nextLine();
						System.out.println(
								"Enter the Category Number :\n 1.COVID 2.SKIN 3.AYURVEDIC 4.DIABETIC 5.PAIN 6.COLD 7.CANCER 8.FOODPOISON");
						int categoryMedicine = sc.nextInt();
						sc.nextLine();
						String specialMedicine = Category.values()[categoryMedicine - 1].type;
						List<Medicine> showNameAndCategory;
						try {
							showNameAndCategory = medicineService.getByNameAndCategory(name, specialMedicine);
							showNameAndCategory.forEach(System.out::println);
						} catch (MedicineNotFoundException e) {
							System.out.println(e.getMessage());
							System.exit(0);
						}

						break;
					case 4:
						System.out.println(
								"Enter the Category Number :\n 1.COVID 2.SKIN 3.AYURVEDIC 4.DIABETIC 5.PAIN 6.COLD 7.CANCER 8.FOODPOISON");
						int showCategory = sc.nextInt();
						sc.nextLine();
						String showSpecialMedicine = Category.values()[showCategory - 1].type;
						System.out.println("Enter the Brand : ");
						String brand = sc.nextLine();
						List<Medicine> showCategoryAndBrand;
						try {
							showCategoryAndBrand = medicineService.getByCategoryAndBrand(showSpecialMedicine, brand);
							showCategoryAndBrand.forEach(System.out::println);
						} catch (MedicineNotFoundException e) {
							System.out.println(e.getMessage());
							System.exit(0);
						}

						break;

					case 5:
						System.out.println(
								"Enter the Category Number :\n 1.COVID 2.SKIN 3.AYURVEDIC 4.DIABETIC 5.PAIN 6.COLD 7.CANCER 8.FOODPOISON");
						int showCategoryList = sc.nextInt();
						sc.nextLine();
						String showSpecialMedicineList = Category.values()[showCategoryList - 1].type;
						System.out.println("Enter the Cost : ");
						double cost = sc.nextDouble();
						sc.nextLine();
						List<Medicine> showCategoryAndCost;
						try {
							showCategoryAndCost = medicineService.getByCategoryAndLessCost(showSpecialMedicineList,
									cost);
							showCategoryAndCost.forEach(System.out::println);
						} catch (MedicineNotFoundException e) {
							System.out.println(e.getMessage());
							System.exit(0);
						}

						break;

					case 6:
						System.out.println("Enter the Name : ");
						String MedicineName = sc.nextLine();
						System.out.println("Enter Availability(true/false) :");
						boolean present = sc.nextBoolean();
						boolean available;
						try {
							available = medicineService.getByNameAndAvailabilty(MedicineName, present);
							if (available) {
								System.out.println("MEDICINE IS AVAILABLE");
							}
						} catch (MedicineNotFoundException e) {
							// TODO Auto-generated catch block
							System.out.println("MEDICINE IS NOT AVAILABLE");
							System.exit(0);
						}
						break;
					case 7:
						System.out.println("Welcome to Appollo cart");
						try {
							System.out.println("Enter the medicine ID :");
							int idInput=sc.nextInt();
							List<Cart> medicineCart=medicineService.getCart(idInput);
							medicineCart.forEach(System.out::println);
							
						} catch (MedicineNotFoundException e) {
							// TODO Auto-generated catch block
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
				sc.nextLine();
				// sc.close();
			} while (choice == 1);

			// sc.close();
		}

	}

	// sc.close();
}
