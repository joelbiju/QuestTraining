package com.quest.oops.library;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[10];
        Members[] members = new Members[10];
        int bookCount = 0;
        int memberCount = 0;

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a new Book");
            System.out.println("2. Add a new Member");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Calculate Fine");
            System.out.println("6. View all Books");
            System.out.println("7. View all Members");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: { // Add a new book
                    if (bookCount < books.length) {
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter ISBN: ");
                        String ISBN = sc.nextLine();
                        books[bookCount++] = new Book(ISBN, title, author);
                        System.out.println("New Book added successfully!");
                    } else {
                        System.out.println("Library is full. Cannot add more books.");
                    }
                    break;
                }
                case 2: { // Add a new member
                    if (memberCount < members.length) {
                        System.out.print("Enter Member Name: ");
                        String memberName = sc.nextLine();
                        System.out.print("Enter Member ID: ");
                        int memberID = sc.nextInt();
                        System.out.print("Enter Membership type (Standard/Premium): ");
                        String memberType = sc.next();
                        sc.nextLine();
                        if (memberType.equalsIgnoreCase("premium")) {
                            members[memberCount++] = new PremiumMember(memberName, memberID);
                        } else {
                            members[memberCount++] = new Members(memberName, memberID, "Standard");
                        }
                        System.out.println("New Member added successfully!");
                    } else {
                        System.out.println("Library membership is full. Cannot add more members.");
                    }
                    break;
                }
                case 3: { // Borrow a book
                    System.out.print("Enter Member ID: ");
                    int memberID = sc.nextInt();
                    Members member = findMemberById(members, memberCount, memberID);
                    if (member == null) {
                        System.out.println("Invalid Member ID.");
                        break;
                    }

                    System.out.print("Enter Book ISBN: ");
                    String ISBN = sc.next();
                    Book book = findBookByISBN(books, bookCount, ISBN);
                    if (book == null) {
                        System.out.println("Invalid Book ISBN.");
                        break;
                    }

                    if (member.borrowBook(book)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Unable to borrow book. Either it's not available or limit exceeded.");
                    }
                    break;
                }
                case 4: { // Return a book
                    System.out.print("Enter Member ID: ");
                    int memberID = sc.nextInt();
                    Members member = findMemberById(members, memberCount, memberID);
                    if (member == null) {
                        System.out.println("Invalid Member ID.");
                        break;
                    }

                    System.out.print("Enter Book ISBN: ");
                    String ISBN = sc.next();
                    Book book = findBookByISBN(books, bookCount, ISBN);
                    if (book == null) {
                        System.out.println("Invalid Book ISBN.");
                        break;
                    }

                    if (member.returnBook(book)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Unable to return book.");
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter Member ID: ");
                    int memberID=sc.nextInt();
                    Members member = findMemberById(members, memberCount, memberID);
                    if (member == null) {
                        System.out.println("Invalid Member ID.");
                        break;
                    }
                    System.out.print("Enter number of days late:");
                    int daysLate = sc.nextInt();
                    double fine = member.calculateLateFee(daysLate);
                    System.out.println("Late fee for member ID " + memberID + " is: $" + fine);
                    break;
                }

                case 6: { // View all books
                    if (bookCount > 0) {
                        System.out.println("\n--- Books in Library ---");
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println(books[i]);
                        }
                    } else {
                        System.out.println("No books in the library.");
                    }
                    break;
                }
                case 7: { // View all members
                    if (memberCount > 0) {
                        System.out.println("\n--- Members in Library ---");
                        for (int i = 0; i < memberCount; i++) {
                            System.out.println(members[i]);
                        }
                    } else {
                        System.out.println("No members in the library.");
                    }
                    break;
                }
                case 8: { // exit
                    System.out.println("Exiting...");
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Helper method to find a member by ID
    private static Members findMemberById(Members[] members, int memberCount, int memberID) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getID() == memberID) {
                return members[i];
            }
        }
        return null;
    }

    // method to find a book by ISBN
    private static Book findBookByISBN(Book[] books, int bookCount, String ISBN) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(ISBN)) {
                return books[i];
            }
        }
        return null;
    }
}
