package com.quest.oops.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Fiction("F123", "The Great Adventure", "John Doe", "2021", true));
        library.addBook(new NonFiction("NF456", "Java Programming", "Jane Smith", "2020", true));

        LibraryMember member1 = new LibraryMember("M001", "Alice", "1234567890");
        library.addMember(member1);
        LibraryMember member2 = new LibraryMember("M002", "Bob", "1890887754");
        library.addMember(member2);

        System.out.println("--- Available Books ---");
        library.displayAllBooks();

        library.borrowBook("F123", member1);


        System.out.println();
        System.out.println("--- Available Books after borrowing ---");
        library.displayAllBooks();

        library.returnBook("F123", member1);

        System.out.println();
        System.out.println("--- Available Books after returning ---");
        library.displayAllBooks();
    }
}
