package com.testcases.training.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.junit.exceptions.InvalidNumberException;
import com.junit.exceptions.NegValueException;
import com.junit.training.Student;

class StudentTest {
Student student=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student=new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student=null;
	}

	@Test
	@DisplayName("Testing totalmarks")
	void testTotalMarks() {
		
		int actual=student.totalMarks(10, 20, 30);
		assertEquals(60,actual,"Should be 60");
	}
	@Test
	@DisplayName("Testing  Negative totalmarks")
	void testTotalMarksNeg() {
		assertThrows(NegValueException.class,()->student.totalMarks(10,-10, -10));
	}
	@Test
	@DisplayName("Testing  Marks more than 100")
	@Tag("MoreMarks")
	void testTotalMarksMore() {
		assertThrows(InvalidNumberException.class,()->student.totalMarks(110,10, 10));
	}
	@Test
	@DisplayName("Testing Grades Fail")
	void testTotalMarksGrade() {
		String actual=student.getGrades(10, 20, 30);
		assertEquals("Fail",actual);
	}
	@Test
	@DisplayName("Testing Grades A")
	void testTotalMarksGradeA() {
		String actual=student.getGrades(90, 99, 90);
		assertEquals("A grade",actual);
	}
	@Test
	@DisplayName("Testing Grades B")
	void testTotalMarksGradeB() {
		String actual=student.getGrades(85, 87, 88);
		assertEquals("B grade",actual);
	}
	@Test
	@DisplayName("Testing Grades C")
	void testTotalMarksGradeC() {
		String actual=student.getGrades(75, 77, 70);
		assertEquals("C grade",actual);
	}
	@Test
	@DisplayName("Testing Grades D")
	void testTotalMarksGradeD() {
		String actual=student.getGrades(55, 67, 78);
		assertEquals("D grade",actual);
	}
	@Test
	@DisplayName("Testing Invalid Numbers")
	void testTotalMarksInvalid() {
		assertThrows(InvalidNumberException.class,()->student.totalMarks(110,10, 10));
	}
	@Test
	@DisplayName("Testing Negative marks")
	void testTotalMarksNegative() {
		assertThrows(NegValueException.class,()->student.totalMarks(10,-10, -10));
	}


}
