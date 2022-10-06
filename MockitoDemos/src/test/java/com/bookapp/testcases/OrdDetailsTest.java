package com.bookapp.testcases;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.details.OrderDetails;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrdDetailsTest {

	@Mock
	IBookService bookservice;
	@InjectMocks
	OrderDetails details;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	Book book1,book2,book3,book4;
	List<Book> bookList=null;
	@BeforeEach
	void setUp() throws Exception {
		//this
		//details=new OrderDetails();
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
	@DisplayName("By Author-List")
	public void testGetByAuthor() {
		String name="Kathy";
		List<Book> expectedbooks=Arrays.asList(book1,book2);
		doReturn(expectedbooks).when(bookservice).getAll();
		List<Book> actualBooks=details.findByAuthor(name);
		assertEquals(expectedbooks,actualBooks);
	}
	@Test
	@DisplayName("By Author -exception")
	public void testGetByNull() {
		String name="Kathy";
		
		doThrow(BookNotFoundException.class).when(bookservice).getAll();
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(name));
	}
	@Test
	@DisplayName("Test by author -empty")
	void testGetByAuthorEmpty() {
		String author="Johny";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		doReturn(new ArrayList<>()).when(bookservice).getAll();
		
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		
		
	}
	@Test
	@DisplayName("Test by author -null")
	void testGetByAuthorNull() {
		String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		doReturn(null).when(bookservice).getAll();
		
		assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
		//original testing starts here
		
		
	}
	@Test
	@DisplayName("Test Order book")
	void testOrderBook() {
		//String author="Kathy";
		//List<Book> booksProxy=Arrays.asList(book3,book4);
		doReturn(book1).when(bookservice).getById(1);
		
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
		doReturn(null).when(bookservice).getById(bookId);
		
		//-->assertThrows(BookNotFoundException.class,()->details.orderBook(bookId));
		//original testing starts here
		String actual=details.orderBook(bookId);
		assertEquals("book not ordered",actual);
		
		
	}
	@Test//check this once again
	@DisplayName("Test Order book -Exceptions")
	void testOrderBookExceptions() throws BookNotFoundException{
		int bookId=1;
		doThrow(BookNotFoundException.class).when(bookservice).getById(bookId);
		
		String actual=details.orderBook(bookId);
		
		assertEquals("book not ordered",actual);
	}
	@Test//check this once again
	@DisplayName("Test AddBook")
	void testAddBook(){
		int bookId=1;
		//
		doNothing().when(bookservice).addBook(book1);
		
		String actual=details.addBook(book1);
		
		assertEquals("Added",actual);
	}
	@Test//check this once again
	@DisplayName("Test AddBook -null")
	void testAddBookNull(){
		int bookId=1;
		//doNothing().when(bookservice).addBook(null);
		
		String actual=details.addBook(null);
		
		assertEquals("wrong input",actual);
	}
	
	@Test//check this once again
	@DisplayName("Test Print Message -name")
	void testPrintMessage(){
		//doNothing().when(bookservice).addBook(null);
		doReturn("welcome").when(bookservice).greetMessage();
		String actual=details.printMessage("mathan");
		
		assertEquals("welcome mathan",actual);
	}
	@Test//check this once again
	@DisplayName("Test Print Message -Negative name")
	void testPrintMessageNeg(){
		//int bookId=1;
		//String name="hi";
		doReturn("welcome").when(bookservice).greetMessage();
		
		String actual=details.printMessage("hi");
		
		assertEquals("welcome!!!your name does not exist",actual);
	}
	@Test//check this once again
	@DisplayName("Test Print Message -Null")
	void testPrintMessageNull(){
		//int bookId=1;
		//String name="hi";
		doReturn(null).when(bookservice).greetMessage();
		
		String actual=details.printMessage("hi");
		
		assertEquals("technical error",actual);
	}
	@Test//check this once again
	@DisplayName("Test Print Message -Exceptions")
	void testPrintMessageExceptions(){
		//int bookId=1;
		//String name="hi";
		doThrow(BookNotFoundException.class).when(bookservice).greetMessage();
		
		assertThrows(BookNotFoundException.class,()->details.printMessage("hi"));
	}

}
