package com.suites;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.junit.training.User;

class UserTest {
User user=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
	user=null;
	}

	@Test
	@DisplayName("Displaying username")
	void test() {
		String name=user.greetUser("Mathan");
		//assertEquals("Hello Mathan",name);
		assertNotNull(name);
		System.out.println(name);
	}
	@ParameterizedTest
	@DisplayName("Displaying-params")
	@ValueSource(strings =  {"Hello","Great Day "})
	void testForParams(String message) {
		//assertEquals("Hello Mathan",name);
		assertEquals(message+"Mathan",user.greetUser("Mathan"));
	}
	@ParameterizedTest
	@ValueSource(ints =  {5,10,15})
	void testForProducts(int expected) {
		assertEquals(expected,user.product(5,2));
	}


}
