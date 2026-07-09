package service;

import model.Book;
import exception.BookNotFoundException;

import java.util.List;

public interface  BookService {

    void addBook(Book book);

    void removeBook(long bookId) throws BookNotFoundException;

    Book searchById(long bookId) throws BookNotFoundException;

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    void displayAllBooks();
}