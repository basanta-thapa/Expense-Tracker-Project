package com.example.expensetracker;

public class DataModel {
    private int id;
    private String Expense;
    private String Amount;
    private String Note;

    public DataModel(int id, String Expense, String Amount, String Note) {
        this.id = id;
        this.Expense = Expense;
        this.Amount = Amount;
        this.Note = Note;
    }

    public int getId() {
        return id;
    }
    public String getExpense() {
        return Expense;
    }
    public String getAmount() {
        return Amount;
    }
    public String getNote(){return Note;}
}