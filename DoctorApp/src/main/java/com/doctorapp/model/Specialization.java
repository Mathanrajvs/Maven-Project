package com.doctorapp.model;

public enum Specialization {
ORTHO("Orthopeadician"),
PEADO("Pediatrician"),
DIABETIC("Diabetician"),
CARDIO("Cardiology"),
PHYSICIAN("General Physician");
	public String type;
	private Specialization(String type) {
		this.type=type;
	}
}
