package com.medicine.model;

public class Medicine {

private String medicineName;
private Integer medicineId;
private String category;
private String brand;
private double cost;
boolean availability;
public Medicine() {
	super();
	// TODO Auto-generated constructor stub
}
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
public String getMedicineName() {
	return medicineName;
}
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}
public int getMedicineId() {
	return medicineId;
}
public void setMedicineId(int medicineId) {
	this.medicineId = medicineId;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}

public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public boolean isAvailability() {
	return availability;
}
public void setAvailability(boolean availability) {
	this.availability = availability;
}
@Override
public String toString() {
	return "Medicine [medicineName=" + medicineName + ", medicineId=" + medicineId + ", category=" + category
			+ ", brand=" + brand + ", cost=" + cost + ", availability=" + availability
			+ "]";
}

}
