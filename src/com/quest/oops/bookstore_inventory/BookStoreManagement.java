package com.quest.oops.bookstore_inventory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BookStoreManagement {
    public static final double DISCOUNT_PERCENT = 10.0;

    public static void main(String[] args) {
        Book[] books = {
                new Book("Java Programming", "John Jacob", 500, 25),
                new Book("Python Programming", "Jane Watson", 350, 26),
                new SpecialEditionBook("Advanced GenAI", "Mark Henry", 750, 10, "Limited Edition Cover"),
                new Book("Data Structures", "Agarwall", 400, 0),
                new SpecialEditionBook("Product Designing", "Erik Matt", 800, 10, "Add on patterns")
        };
        double pricePoint = 700;
        System.out.println("\nBooks priced above " + pricePoint + ":");
        Arrays.stream(books).filter(book -> book.getPrice() > pricePoint).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("\nDiscount price for all books:");
        for (Book book : books) {
            double discountPrice = book.getPrice() * (1-(DISCOUNT_PERCENT/100));
            System.out.println(book.getTitle()+ ": Original Price = "+book.getPrice()+", Discount Price = "+discountPrice);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nPurchase Details: ");
        System.out.print("Enter book name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter quantity of books required: ");
        int quantity = sc.nextInt();

        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookName)) {
                bookFound = true;
                try {
                    book.stockCheck(quantity);
                    System.out.println("Successfully purchased book " + book.getTitle());
                } catch (OutofStockException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book not found");
        }
    }
}
