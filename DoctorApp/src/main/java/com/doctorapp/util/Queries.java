package com.doctorapp.util;

public class Queries {
public static final String CREATEQUERY="create table doctor(doctorName varchar(20),doctorId integer primary key auto_increment,speciality varchar(20),"
		+ "fees double,experience int,startTime timestamp,endTime timestamp)";
public static final String INSERTQUERY="insert into doctor(doctorName,speciality,fees,experience,startTime,endTime) values(?,?,?,?,?,?)";
public static final String  SELECTQUERY="select * from doctor";
public static final String UPDATEQUERY="update doctor set fees=? where doctorId=?";
public static final String DELETEQUERY="delete from doctor where doctorId=?";
public static final String FINDQUERY="select * from doctor where doctorId=?";

public static final String SPECIALITYQUERY="select * from doctor where speciality=?";
public static final String SPECIALITYANDEXPERIENCEQUERY="select * from doctor where speciality=? and experience=?";
public static final String SPECIALITYANDFEESQUERY="select * from doctor where speciality=? and fees=?";
public static final String TIMEBETWEENQUERY="select * from doctor where startTime = ? ";
}
