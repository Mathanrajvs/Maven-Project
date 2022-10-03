package com.testcases.training.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit.exceptions.NegValueException;
import com.junit.exceptions.OutOfLimitException;
import com.junit.trail.Bank;

class BankTest {
Bank bank=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank=new Bank(1000);
	}

	@AfterEach
	void tearDown() throws Exception {
		bank=null;
	}

	@Test
	@DisplayName("Testing  Negative Deposit")
	void testNegativeValueForDeposit() {
		assertThrows(NegValueException.class,()->bank.deposit(-100));
		
	}
	@Test
	@DisplayName("Testing  OutofLimitException Deposit")
	void testForMoreDeposit() {
		assertThrows(OutOfLimitException.class,()->bank.deposit(20000));
		
	}
	@Test
	@DisplayName("Testing  Negative Withdraw")
	void testNegativeValueForWithdraw() {
		assertThrows(NegValueException.class,()->bank.withdraw(-100));
		
	}
	@Test
	@DisplayName("Testing  OutofLimitException Withdraw")
	void testForMoreWithdraw() {
		assertThrows(OutOfLimitException.class,()->bank.withdraw(20000));
		
	}

}
