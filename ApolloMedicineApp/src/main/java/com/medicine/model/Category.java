package com.medicine.model;

public enum Category {
	/**
	 * Stores the disease types in a hospital
	 */
	COVID("Covid Essentials"),  
	SKIN("Skin Care"), 
	AYURVEDIC("Ayurvedic Care"),
	DIABETIC("Diabetic Care"), PAIN("Pain Reief"),COLD("Cold and Cough"),
	CANCER("Cancer"), FOODPOISON("Food Poisoning");
	/**
	 * Stores the category type
	 * 
	 */
	public String type;
	/**
	 * Set the medicine category type
	 * @param type to specify the disease name in enum
	 */
	private Category(String type) {
		this.type = type;
	}
}
