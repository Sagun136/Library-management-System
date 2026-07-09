package model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private long memberId;
    private String name;
    private String email;
    private List<Book> issuedBooks;

    public Member() {
        issuedBooks = new ArrayList<>();
    }

    public Member(long memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.issuedBooks = new ArrayList<>();
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<Book> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void addIssuedBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public void displayMember() {
        System.out.println("Member ID : " + memberId);
        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
    }
}