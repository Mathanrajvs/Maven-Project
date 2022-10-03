package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
List<Book> getAll();
void addBook(Book book);
List<Book> getByLessPrice(double price);
Book getById(int bookId) throws BookNotFoundException;
}
