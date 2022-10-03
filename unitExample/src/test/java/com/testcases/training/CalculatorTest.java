package com.testcases.training;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.junit.example.Calculator;

class CalculatorTest {
	Calculator calculator=null;
@BeforeAll
public static void init() {
	System.out.println("called before all test cases");
}
@BeforeEach
public void setup() {
	System.out.println("Called before each test cases");
	calculator=new Calculator();
}
@Test
@DisplayName("Testing Add Method")
@Tag("Add")
public void testAdd() {
	int actual=calculator.add(10,20);
	assertEquals(30,actual,"Should be 30");
	System.out.println("....testing a method....");
	
	
}
@Test
@DisplayName("Testing Multiply Method")
public void testMul() {
	int actual=calculator.product(10,20);
	assertEquals(200,actual,"Should be 200");
	System.out.println("....testing a method....");
}
@RepeatedTest(value=10,name="{displayName} {currentRepetition}")
@DisplayName("Printing random Number")
public void testPrintRandom() {
	double actual=calculator.checkData(4);
	assertEquals(3,actual,0.5);
	System.out.println("....testing a method....");
	
	
}
@AfterEach
public void teardown() {
	System.out.println("call after each");
	calculator=null;
}
@AfterAll
@Disabled
public static void cleanup() {
	System.out.println("called after all");
}

}
