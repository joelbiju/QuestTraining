package com.quest.oops.librarymanagementsystem;

public class LibraryMember {
    private String memberID;
    private String Name;
    private String contactInfo;
    private String[] borrowedBooks = new String[5];

    public LibraryMember(String memberID, String Name, String contactInfo) {
        this.memberID = memberID;
        this.Name = Name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = borrowedBooks;
    }
    public String getMemberID() {
        return memberID;
    }
    public String getName() {
        return Name;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public String[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public void setBorrowedBooks(String[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(String ISBN) {
        boolean added = false;
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = ISBN;
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Cannot borrow books. Max limit reached.");
        }
    }
    public void returnBook(String ISBN) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] !=null && borrowedBooks[i].equals(ISBN)) {
                borrowedBooks[i] = null;
                break;
            } else {
                System.out.println("Book with ISBN " + ISBN + " not found in borrowed list.");
            }
        }
    }

}
