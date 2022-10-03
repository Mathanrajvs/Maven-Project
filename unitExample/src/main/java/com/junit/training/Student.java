package com.junit.training;

import com.junit.exceptions.InvalidNumberException;
import com.junit.exceptions.NegValueException;

public class Student {
public int totalMarks(int markone,int marktwo,int markthree)  {
	if(markone>100 || marktwo>100 ||markthree>100) {
		throw new InvalidNumberException();
	}
	if(markone<0 || marktwo<0 ||markthree<0) {
		throw new NegValueException();
	}
	
	return markone+markthree+marktwo;
	
}
public String getGrades(int...marks) {
	int sum=0;
	int count=0;
	String grade=null;
	for(int total:marks) {
		if(total>100) {
			throw new InvalidNumberException();
		}
		if(total<0) {
			throw new NegValueException();
		}
		count+=1;
		sum+=total;
	}
	int average=sum/count;
	
	if(average>90) {
		grade="A grade";
	}
	if(average>80&&average<90) {
		grade="B grade";
	}
	if(average>70&&average<80) {
		grade="C grade";
	}
	if(average>50&&average<70) {
		grade="D grade";
	}
	if(average<50) {
		grade="Fail";
	}
	return grade;

}
}
