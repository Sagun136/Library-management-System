package model;

public class Ebook extends Book {

    private String downloadUrl;

    public Ebook() {
    }

    public Ebook(long bookId, String title, String author, int quantity, String downloadUrl) {
        super(bookId, title, author, quantity);
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book ID : " + getBookId());
        System.out.println("Title : " + getTitle());
        System.out.println("Author : " + getAuthor());
        System.out.println("Quantity : " + getQuantity());
        System.out.println("Download URL : " + downloadUrl);
    }
}