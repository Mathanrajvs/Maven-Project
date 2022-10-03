package com.bookapp.testcases;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.details.OrderDetails;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	@Mock
	IBookService bookservice;
	OrderDetails details;
	Book book1,book2,book3,book4;
	List<Book> bookList=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		details=new OrderDetails();
		details.setBookservice(bookservice);
		book1=new Book("Java",1,"Kathy",96);
		book2=new Book("My Sql",2,"Kathy",90);
		book3=new Book("HTML",3,"Johny",95);
		book4=new Book("ANT",4,"Johny",95);
		bookList=Arrays.asList(book1,book2,book3,book4);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		details=null;
	}

	@Test
	@DisplayName("Test by author -List")
	void testGetByAuthor() {
		String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book1,book2);
		when(bookservice.getAll()).thenReturn(bookList);
		
		//original testing starts here
		List<Book> books=details.findByAuthor(author);
		
		//filter by author,sort by title
		List<Book> expected=Arrays.asList(book1,book2);
		assertEquals(expected,books);
		
	}
//	@Test
//	void testGetByAuthorSorted() {
//		String author="Johny";
//		List<Book> booksProxy=Arrays.asList(book3,book4);
//		when(bookservice.getByAuthor(author)).thenReturn(booksProxy);
//		
//		//original testing starts here
//		List<Book> books=details.findByAuthor(author);
//		System.out.println(books);
//		assertEquals(Arrays.asList(book4,book3),books);
//		
//	}
	@Test
	@DisplayName("Test by author -empty")
	void testGetByAuthorEmpty() {
		String author="Johny";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		when(bookservice.getAll()).thenReturn(new ArrayList<>());
		
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		
		
	}
	@Test
	@DisplayName("Test by author -null")
	void testGetByAuthorNull() {
		String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		when(bookservice.getAll()).thenReturn(null);
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		
		
	}
	@Test
	@DisplayName("Test by author -exception")
	void testGetByAuthorException() {
		String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		when(bookservice.getAll()).thenThrow(BookNotFoundException.class);
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		
		
	}
	@Test
	@DisplayName("Test Order book")
	void testOrderBook() {
		//String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		when(bookservice.getById(1)).thenReturn(book1);
		
		//assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		String actual=details.orderBook(1);
		assertEquals("Ordered",actual);
		
		
	}
	@Test
	@DisplayName("Test Order book -null")
	void testOrderBookNull() {
		int bookId=1;
		//String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		when(bookservice.getById(bookId)).thenReturn(null);
		
		assertThrows(BookNotFoundException.class,()->details.orderBook(bookId));
		//original testing starts here
		//String actual=details.orderBook(1);
		//assertEquals("ordered",actual);
		
		
	}
	@Test//check this once again
	@DisplayName("Test Order book -Exceptions")
	void testOrderBookExceptions() {
		int bookId=10;
		when(bookservice.getById(bookId)).thenThrow(BookNotFoundException.class);
		
		String actual=details.orderBook(bookId);
		
		assertEquals(BookNotFoundException.class,actual,"Order is placed");

		
		
	}

}
