
package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.details.OrderDetails;
import com.bookapp.service.BookDetails;
import com.bookapp.service.IBookService;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class BookDetailsTest {

	
	BookDetails bookDetails=null;
	@Spy
	BookDetails spyDetails;
	@Mock
	BookDetails mockDetails;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bookDetails=new BookDetails();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDetails=null;
	}

	@Test
	@DisplayName("Test by Book Details -List")
	void test() {
		List<String> actual=bookDetails.showBooks();
		List<String> expected=Arrays.asList("c","c++","java");
		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Test show Books using spy")
	void testShowBooksSpy() {
		//when(spyDetails.showBooks()).thenReturn(Arrays.asList("c","c++","java"));
		List<String> actual=spyDetails.showBooks();
		System.out.println(actual);
//		List<String> expected=Arrays.asList("c","c++","java");
//		assertEquals(expected,actual);
	}
	@Test
	@DisplayName("Test show Books using mock")
	void testShowBooksMock() {
		when(mockDetails.showBooks()).thenReturn(Arrays.asList("Apple","Orange","Banana"));
		List<String> actual=mockDetails.showBooks();
		System.out.println(actual);
//		List<String> expected=Arrays.asList("c","c++","java");
//		assertEquals(expected,actual);
	}

}
