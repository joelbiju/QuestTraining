package com.quest.oops.library;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean availability) {
        this.isAvailable = availability;
    }

    @Override
    public String toString() {
        return "Book [ISBN=" + ISBN + ", Title=" + title + ", Author=" + author + ", Available=" + (isAvailable ? "Yes" : "No") + "]";
    }
}
