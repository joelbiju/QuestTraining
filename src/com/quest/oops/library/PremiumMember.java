package com.quest.oops.library;

import java.lang.reflect.Member;

public class PremiumMember extends Members {

    public PremiumMember(String name, int ID) {
        super(name, ID, "Premium");
    }

    @Override
    public boolean borrowBook(Book book) {
        if (booksBorrowed.length < 10) {
            super.borrowBook(book);
            return true;
        }
        return false;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.5;   //$0.5 per day
    }

}
