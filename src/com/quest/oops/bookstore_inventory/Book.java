package com.quest.oops.bookstore_inventory;

public class Book {
    private String title;
    private String author;
    private int price;
    private int stock;

    public Book(String title, String author, int price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    public void stockCheck(int quantity) throws OutofStockException {
        if (quantity>this.getStock()) {
            throw new OutofStockException(this.title);
        }
    }
}
