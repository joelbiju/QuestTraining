package com.quest.oops.librarymanagementsystem;

public interface LibraryOperations {
    void addBook(Book book);
    void displayAllBooks();
    boolean searchBook(String keyword);
    void displayAllMembers();
    void borrowBook(String ISBN, LibraryMember member);
    void returnBook(String ISBN, LibraryMember member);
}
