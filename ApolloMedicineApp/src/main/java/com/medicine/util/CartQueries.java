package com.medicine.util;

public class CartQueries {

public static final String QUERYFORCREATECART="create table medicineCart(medicineName varchar(20),medicineId int,cost double)";
public static final String QUERYBYCART="insert  into medicineCart(medicineName,medicineId,cost) select medicineName,medicineId,cost from medicine where medicineName like ?";
public static final String QUERYFORSELECTCART="select * from medicineCart";
}
