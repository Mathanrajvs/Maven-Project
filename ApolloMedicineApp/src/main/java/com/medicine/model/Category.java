package com.medicine.model;

public enum Category {
	COVID("Covid Essentials"),  
	SKIN("Skin Care"), 
	AYURVEDIC("Ayurvedic Care"),
	DIABETIC("Diabetic Care"), PAIN("Pain Reief"),COLD("Cold and Cough"),
	CANCER("Cancer"), FOODPOISON("Food Poisoning");

	public String type;

	private Category(String type) {
		this.type = type;
	}
}
