package com.quest.oops.librarymanagementsystem;

public class Library implements LibraryOperations {
    private final int MAX_BOOKS = 100;
    private final int MAX_MEMBERS = 50;

    private final LibraryMember[] members;
    private final Book[] books;
    private int currentIndex = 0;
    private int memberIndex = 0;


    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.members = new LibraryMember[MAX_MEMBERS];
    }

    @Override
    public void addBook(Book book) {
        if (currentIndex < MAX_BOOKS) {
            books[currentIndex] = book;
            currentIndex++;
        } else {
            System.out.println("Book limit reached");
        }
    }

    @Override
    public void displayAllBooks() {
        for (Book book : books) {
            if (book!=null && book.isAvailabilityStatus()) {
                book.displayBookInfo();
            }
        }
    }

    @Override
    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getISBN().equals(keyword)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void displayAllMembers() {
        for (LibraryMember member : members) {
            System.out.println("Member ID: " + member.getMemberID() + ", Name: " + member.getName());
        }
    }

    @Override
    public void borrowBook(String ISBN, LibraryMember member) {
        for (Book book : books) {
            if (book.isAvailabilityStatus() && book.getISBN().equals(ISBN)) {
                book.setAvailabilityStatus(false);
                member.borrowBook(ISBN);
                return;
            }
        }
    }

    @Override
    public void returnBook(String ISBN, LibraryMember member) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && !book.isAvailabilityStatus()) {
                book.setAvailabilityStatus(true);
                member.returnBook(ISBN);
                return;
            }
        }
    }

    public void addMember(LibraryMember member) {
        if (memberIndex < MAX_MEMBERS) {
            members[memberIndex] = member;
            memberIndex++;
        } else {
            System.out.println("Member limit reached");
        }
    }
}
