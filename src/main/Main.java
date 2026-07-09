package main;
import exception.BookNotFoundException;
import exception.BookOutOfStockException;
import exception.MaxBookLimitReachedException;
import exception.MemberNotFoundException;
import model.Book;
import model.Ebook;
import model.Member;
import model.PhysicalBook;
import sevice.impl.BookServiceImpl;
import sevice.impl.LibraryServiceImpl;
import util.MenuUtil;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookServiceImpl bookService = new BookServiceImpl();
        LibraryServiceImpl libraryService = new LibraryServiceImpl(bookService);

        int choice;

        do {

            MenuUtil.displayMenu();
            choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.println("1. Physical Book");
                        System.out.println("2. EBook");
                        System.out.print("Choose Book Type: ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Book ID: ");
                        long id = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();

                        if (type == 1) {

                            System.out.print("Shelf Location: ");
                            String shelf = sc.nextLine();

                            Book physicalBook = new PhysicalBook(id, title, author, qty, shelf);

                            bookService.addBook(physicalBook);

                        } else {

                            System.out.print("Download URL: ");
                            String url = sc.nextLine();

                            Book ebook = new Ebook(id, title, author, qty, url);

                            bookService.addBook(ebook);
                        }

                        break;

                    case 2:

                        System.out.print("Book ID: ");
                        long removeId = sc.nextLong();

                        bookService.removeBook(removeId);

                        break;

                    case 3:

                        System.out.println("1. Search by ID");
                        System.out.println("2. Search by Title");
                        System.out.println("3. Search by Author");

                        int searchChoice = sc.nextInt();
                        sc.nextLine();

                        if (searchChoice == 1) {

                            System.out.print("Book ID: ");
                            long searchId = sc.nextLong();

                            Book book = bookService.searchById(searchId);

                            book.displayDetails();

                        } else if (searchChoice == 2) {

                            System.out.print("Title: ");
                            String searchTitle = sc.nextLine();

                            List<Book> books = bookService.searchByTitle(searchTitle);

                            for (Book b : books) {
                                b.displayDetails();
                            }

                        } else {

                            System.out.print("Author: ");
                            String searchAuthor = sc.nextLine();

                            List<Book> books = bookService.searchByAuthor(searchAuthor);

                            for (Book b : books) {
                                b.displayDetails();
                            }
                        }

                        break;

                    case 4:

                        bookService.displayAllBooks();

                        break;

                    case 5:

                        System.out.print("Member ID: ");
                        long memberId = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        Member member = new Member(memberId, name, email);

                        libraryService.registerMember(member);

                        break;

                    case 6:

                        System.out.print("Member ID: ");
                        long issueMember = sc.nextLong();

                        System.out.print("Book ID: ");
                        long issueBook = sc.nextLong();

                        libraryService.issueBook(issueMember, issueBook);

                        break;

                    case 7:

                        System.out.print("Member ID: ");
                        long returnMember = sc.nextLong();

                        System.out.print("Book ID: ");
                        long returnBook = sc.nextLong();

                        libraryService.returnBook(returnMember, returnBook);

                        break;

                    case 8:

                        System.out.print("Member ID: ");
                        long viewMember = sc.nextLong();

                        libraryService.viewIssuedBooks(viewMember);

                        break;

                    case 9:

                        System.out.println("Thank you for using Library Management System.");

                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (BookNotFoundException |
                     BookOutOfStockException |
                     MemberNotFoundException |
                     MaxBookLimitReachedException e) {

                System.out.println(e.getMessage());

            }

        } while (choice != 9);

        sc.close();
    }
}