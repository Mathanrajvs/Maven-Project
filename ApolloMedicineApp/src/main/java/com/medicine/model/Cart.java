package com.medicine.model;

public class Cart {
	/**
	 * Stores the medicine name
	 */
	private String medicineName;
	/**
	 * Stores the medicine id
	 */
	private Integer medicineId;
	/**
	 * Stores the medicine cost
	 */
	private double cost;
	/**
	 * Constructs the empty cart
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructs an cart with parameters of medicine name,medicine id and medicine cost.
	 * @param medicinename the medicine name
	 * @param medicineId the medicine id
	 * @param cost the medicine cost
	 * */
	public Cart(String medicineName, Integer medicineId, double cost) {
		super();
		this.medicineName = medicineName;
		this.medicineId = medicineId;
		this.cost = cost;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Cart [medicineName=" + medicineName + ", medicineId=" + medicineId + ", cost=" + cost + "]";
	}
	
	
}
