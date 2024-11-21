package com.quest.oops.librarymanagementsystem;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private String publicationYear;
    private boolean availabilityStatus;

    public Book(String ISBN, String title, String author, String publicationYear, boolean availabilityStatus) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.availabilityStatus = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void displayBookInfo() {
        System.out.println("\n--- Available Books ---");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Availability Status: " + availabilityStatus);
    }

    public boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
}
