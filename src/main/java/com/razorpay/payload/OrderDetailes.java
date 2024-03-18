package com.razorpay.payload;

public class OrderDetailes {
    int amount;
    String currency;
    String noteSubject;
    String noteContent;

    public OrderDetailes() {
    }

    public OrderDetailes(int amount, String currency, String noteSubject, String noteContent) {
        this.amount = amount;
        this.currency = currency;
        this.noteSubject = noteSubject;
        this.noteContent = noteContent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
