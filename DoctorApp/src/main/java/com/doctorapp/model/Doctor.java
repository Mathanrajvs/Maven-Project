package com.doctorapp.model;

import java.time.LocalDateTime;

public class Doctor {
	private String doctName;
	private Integer doctotId;
	private String speciality;
	private double fees;
	private int experience;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Doctor(String doctName, Integer doctotId, String speciality, double fees, int experience,
			LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.doctName = doctName;
		this.doctotId = doctotId;
		this.speciality = speciality;
		this.fees = fees;
		this.experience = experience;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}


	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public String getDoctName() {
		return doctName;
	}
	public void setDoctName(String doctName) {
		this.doctName = doctName;
	}
	public Integer getDoctotId() {
		return doctotId;
	}
	public void setDoctotId(Integer doctotId) {
		this.doctotId = doctotId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Doctor [doctName=" + doctName + ", doctotId=" + doctotId + ", speciality=" + speciality + ", fees="
				+ fees + ", experience=" + experience + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	
}
