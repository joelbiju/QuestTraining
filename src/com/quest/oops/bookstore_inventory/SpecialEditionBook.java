package com.quest.oops.bookstore_inventory;

public class SpecialEditionBook extends Book{
    private String specialFeature;
    public SpecialEditionBook(String title, String author, int price, int stock, String specialFeature) {
        super(title, author, price, stock);
        this.specialFeature = specialFeature;
    }

    public String getSpecialFeature() {
        return specialFeature;
    }
}
