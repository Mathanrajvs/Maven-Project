package com.medicine.util;

public class UserQueries {
public static final String CREATEQUERY="create table user(userName varchar(20),name varchar(20),mobile int ,email varchar(30),city varchar(20),userId varchar(15) primary key,password varchar(20))";
public static final String INSERTQUERY="insert into user values(?,?,?,?,?,?,?);";
public static final String  SELECTQUERY="select * from user";
public static final String UPDATEQUERY="update user set password=? where userId=?";
public static final String DELETEQUERY="delete from user where userId=?";
public static final String FINDQUERY="select * from user where userId=?";

public static final String QUERYFORLOGIN="select * from user where userId=? and password=?";
}