package sevice.impl;

import exception.BookNotFoundException;
import exception.BookOutOfStockException;
import exception.MaxBookLimitReachedException;
import exception.MemberNotFoundException;
import model.Book;
import model.Member;
import service.LibraryService;

import java.util.HashMap;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {

    private Map<Long, Member> members = new HashMap<>();
    private BookServiceImpl bookService;

    public LibraryServiceImpl(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Override
    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member registered successfully.");
    }

    @Override
    public void issueBook(long memberId, long bookId)
            throws MemberNotFoundException,
            BookNotFoundException,
            BookOutOfStockException,
            MaxBookLimitReachedException {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException("Member not found.");
        }

        Book book = bookService.searchById(bookId);

        if (book.getQuantity() == 0) {
            throw new BookOutOfStockException("Book is out of stock.");
        }

        if (member.getIssuedBooks().size() >= 3) {
            throw new MaxBookLimitReachedException("Maximum book limit reached.");
        }

        member.addIssuedBook(book);
        book.setQuantity(book.getQuantity() - 1);

        System.out.println("Book issued successfully.");
    }

    @Override
    public void returnBook(long memberId, long bookId)
            throws MemberNotFoundException,
            BookNotFoundException {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException("Member not found.");
        }

        Book book = bookService.searchById(bookId);

        member.returnBook(book);
        book.setQuantity(book.getQuantity() + 1);

        System.out.println("Book returned successfully.");
    }

    @Override
    public void viewIssuedBooks(long memberId)
            throws MemberNotFoundException {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException("Member not found.");
        }

        System.out.println("Member : " + member.getName());

        if (member.getIssuedBooks().isEmpty()) {
            System.out.println("No books issued.");
            return;
        }

        System.out.println("Issued Books:");

        int count = 1;

        for (Book book : member.getIssuedBooks()) {
            System.out.println(count + ". " + book.getTitle());
            count++;
        }
    }
}