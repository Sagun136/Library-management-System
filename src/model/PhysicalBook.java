package model;

public class PhysicalBook extends Book {

    private String shelfLocation;

    public PhysicalBook() {
    }

    public PhysicalBook(long bookId, String title, String author, int quantity, String shelfLocation) {
        super(bookId, title, author, quantity);
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book ID : " + getBookId());
        System.out.println("Title : " + getTitle());
        System.out.println("Author : " + getAuthor());
        System.out.println("Quantity : " + getQuantity());
        System.out.println("Shelf Location : " + shelfLocation);
    }
}