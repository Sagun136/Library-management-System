package service;

import exception.BookNotFoundException;
import exception.BookOutOfStockException;
import exception.MaxBookLimitReachedException;
import exception.MemberNotFoundException;
import model.Member;

public interface LibraryService {

    void registerMember(Member member);

    void issueBook(long memberId, long bookId)
            throws MemberNotFoundException,
            BookNotFoundException,
            BookOutOfStockException,
            MaxBookLimitReachedException;

    void returnBook(long memberId, long bookId)
            throws MemberNotFoundException,
            BookNotFoundException;

    void viewIssuedBooks(long memberId)
            throws MemberNotFoundException;
}
