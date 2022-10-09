package com.medicine.util;

public class Queries {
public static final String CREATEQUERY="create table medicine(medicineName varchar(20),medicineId int primary key,category varchar(20),brand varchar(20),cost double,availability BIT(1))";
public static final String INSERTQUERY="insert into medicine values(?,?,?,?,?,?);";
public static final String  SELECTQUERY="select * from medicine";
public static final String UPDATEQUERY="update medicine set cost=? where medicineId=?";
public static final String DELETEQUERY="delete from medicine where medicineId=?";
public static final String FINDQUERY="select * from medicine where medicineId=?";

public static final String QUERYBYNAMECONTAINING="select * from medicine where medicineName like ?";
public static final String QUERYBYCATEGORY="select * from medicine where category=?";
public static final String QUERYBYNAMEANDCATEGORY="select * from medicine where medicineName like ? and category=?";
public static final String QUERYBYNAMEANDAVAILABILITY="select * from medicine where medicineName like ? and availability=?";
public static final String QUERYBYCATEGORYANDBRAND="select * from medicine where category=? and brand=? ";
public static final String QUERYFORCATEORYANDCOST="select * from medicine where category=? and cost=? ";



}
