package com.junit.trail;

import com.junit.exceptions.NegValueException;
import com.junit.exceptions.OutOfLimitException;

public class Bank {
double balance;

public Bank(double balance) {
	super();
	this.balance=balance;
	// TODO Auto-generated constructor stub
}
public double deposit(int amount) {
	if(amount>10000) {
		throw new OutOfLimitException();
	}
	if(amount<0) {
		throw new NegValueException();
	}
	balance+=amount;
	return balance;
}

public double withdraw(int amount){
	if(amount>10000) {
		throw new OutOfLimitException();
	}
	if(amount<0) {
		throw new NegValueException();
	}
	balance-=amount;
	return balance;
}
}
