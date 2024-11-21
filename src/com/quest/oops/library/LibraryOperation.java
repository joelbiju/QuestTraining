package com.quest.oops.library;

public interface LibraryOperation {

    public boolean borrowBook(Book book);
    public boolean returnBook(Book book);
    public double calculateLateFee(int daysLate);
}
