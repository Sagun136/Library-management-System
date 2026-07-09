package sevice.impl;

import exception.BookNotFoundException;
import model.Book;
import service.BookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    private Map<Long, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        System.out.println("Book added successfully.");
    }

    @Override
    public void removeBook(long bookId) throws BookNotFoundException {

        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found.");
        }

        books.remove(bookId);
        System.out.println("Book removed successfully.");
    }

    @Override
    public Book searchById(long bookId) throws BookNotFoundException {

        if (!books.containsKey(bookId)) {
            throw new BookNotFoundException("Book not found.");
        }

        return books.get(bookId);
    }

    @Override
    public List<Book> searchByTitle(String title) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public List<Book> searchByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-10s%n",
                "ID", "Title", "Author", "Copies");
        System.out.println("-----------------------------------------------");

        for (Book book : books.values()) {

            System.out.printf("%-10d %-20s %-15s %-10d%n",
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getQuantity());
        }

        System.out.println("-----------------------------------------------");
    }

    public Map<Long, Book> getBooks() {
        return books;
    }
}