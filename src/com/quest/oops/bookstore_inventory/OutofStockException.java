package com.quest.oops.bookstore_inventory;

public class OutofStockException extends Exception {
    public OutofStockException(String name) {
        super(name+" is currently out of stock");
    }
}
