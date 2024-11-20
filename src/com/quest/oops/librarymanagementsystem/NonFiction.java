package com.quest.oops.librarymanagementsystem;

public class NonFiction extends Book{
    public NonFiction(String ISBN, String title, String author, String publicationYear, boolean availabilityStatus) {
        super(ISBN, title, author, publicationYear, availabilityStatus);
    }

    @Override
    public void displayBookInfo() {
        System.out.println("Non-Fiction Book - ISBN: " + this.getISBN()+", Title: " + this.getTitle()+", Author: " + this.getAuthor()+", Year: " + this.getPublicationYear());
    }
}
