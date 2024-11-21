package com.quest.oops.library;

public class Members implements LibraryOperation {
    private String name;
    private int ID;
    private String membershipType;
    public Book[] booksBorrowed;

    public Members(String name, int ID, String membershipType) {
        this.name = name;
        this.ID = ID;
        this.membershipType = membershipType;
        this.booksBorrowed = new Book[5];
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getMembershipType() {
        return membershipType;
    }

    @Override
    public boolean borrowBook(Book book) {
        if (book.isAvailable()) {
            for (int i = 0; i < booksBorrowed.length; i++) {
                if (booksBorrowed[i] == null) {
                    booksBorrowed[i] = book;
                    book.setAvailable(false);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        for (int i = 0; i < booksBorrowed.length; i++) {
            if (booksBorrowed[i] == book) {
                book.setAvailable(true);
                booksBorrowed[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.0;  //$1 per day
    }

    @Override
    public String toString() {
        StringBuilder borrowedBooksDetails = new StringBuilder();
        for (Book book : booksBorrowed) {
            if (book != null) {
                borrowedBooksDetails.append(book).append("\n");
            }
        }
        return "Members [name=" + name + ", ID=" + ID + ", membershipType=" + membershipType + ", booksBorrowed=" + borrowedBooksDetails;
    }
}
