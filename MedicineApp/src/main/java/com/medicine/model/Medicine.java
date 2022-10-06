package com.medicine.model;
/**
 * Represents the Medicine
 */
public class Medicine {
/**
 * Stores the medicine name
 */
private String medicineName;
/**
 * Stores the medicine id
 */
private Integer medicineId;
/**
 * Stores the medicine category
 */
private String category;
/**
 * Stores the medicine brand
 */
private String brand;
/**
 * Stores the medicine cost
 */
private double cost;
/**
 * Check the medicine is available or not
 */
boolean availability;
/**
 * Constructs the empty medicine
 */
public Medicine() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * Constructs an employee with parameters of medicine name,medicine id,medicine category,medicine brand,
 * medicine cost and medicine availability
 * @param medicinename the medicine name
 * @param medicineId the medicine id
 * @param category the medicine category
 * @param brand the medicine brand
 * @param cost the medicine cost
 * @param availability the medicine availability
 */
public Medicine(String medicineName, int medicineId, String category, String brand, double cost,
		boolean availability) {
	super();
	this.medicineName = medicineName;
	this.medicineId = medicineId;
	this.category = category;
	this.brand = brand;
	this.cost = cost;
	this.availability = availability;
}
/**
 * retrieve the medicine name
 * @return medicinename the medicine name
 */
public String getMedicineName() {
	return medicineName;
}
/**
 * Set the medicine name
 * @param medicinename the medicine name
 */
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}
/**
 * retrieve the medicine id
 * @return medicineId the medicine id
 */
public int getMedicineId() {
	return medicineId;
}
/**
 * Set the medicine Id
 * @param medicineId the medicine id
 */
public void setMedicineId(int medicineId) {
	this.medicineId = medicineId;
}
/**
 * retrieve the medicine category
 * @return category the medicine category
 */
public String getCategory() {
	return category;
}
/**
 * Set the medicine category
 * @param category the medicine category
 */
public void setCategory(String category) {
	this.category = category;
}
/**
 * retrieve the medicine brand
 * @return brand the medicine brand
 */
public String getBrand() {
	return brand;
}
/**
 * Set the medicine brand
 * @param brand the medicine brand
 */
public void setBrand(String brand) {
	this.brand = brand;
}
/**
 * retrieve the medicine cost
 * @return cost the medicine cost
 */

public double getCost() {
	return cost;
}
/**
 * Set the medicine cost
 * @param cost the medicine cost
 */
public void setCost(double cost) {
	this.cost = cost;
}
/**
 * retrieve the medicine availability
 * @return availability the medicine is available or not
 */
public boolean isAvailability() {
	return availability;
}
/**
 * Set the medicine availability
 * @param availability the medicine availability
 */
public void setAvailability(boolean availability) {
	this.availability = availability;
}
/**
 * retrieve the medicine information
 * @return a string of medicine information
 */
@Override
public String toString() {
	return "Medicine [medicineName=" + medicineName + ", medicineId=" + medicineId + ", category=" + category
			+ ", brand=" + brand + ", cost=" + cost + ", availability=" + availability
			+ "]";
}

}
