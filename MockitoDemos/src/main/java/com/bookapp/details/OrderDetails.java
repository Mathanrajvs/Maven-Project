package com.bookapp.details;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

public class OrderDetails {
	IBookService bookservice;

	public void setBookservice(IBookService bookservice) {
		this.bookservice = bookservice;
	}

	public List<Book> findByAuthor(String author) {
		List<Book> books = bookservice.getAll();
		if (books == null || books.isEmpty())
			throw new BookNotFoundException();
		books = books.stream().sorted((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()))
				.filter((book) -> book.getAuthor() == "Kathy").collect(Collectors.toList());
		return books;
	}

	public String addBook(Book book) {
		if (book != null) {
			bookservice.addBook(book);
			return "Added";
		} else {
			return "wrong input";
		}
	}

//List<Book> getByLessPrice(double price){
//	
//}
	public String orderBook(int bookId) {
		Book book;
		try {
			book = bookservice.getById(bookId);

			if (book == null)
				return "book not ordered";

		} catch (BookNotFoundException e) {
			return "book not ordered";
		}

		return "Ordered";
	}
	public String printMessage(String name) {
		
		String result=bookservice.greetMessage();
		
		if(result==null) {
			return "technical error";
		}
		if(name.equals("mathan")) {
			return result+" "+name;
		}
		return result+"!!!your name does not exist";
		


	}
}

