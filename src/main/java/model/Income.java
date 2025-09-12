package model;

import java.time.LocalDate;

public class Income {
    private int incomeId;
    private int userId;
    private double amount;
    private String category;
    private LocalDate date;

    public Income(int userId, double amount, String category, LocalDate date) {
        this.userId = userId;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters and Setters
    public int getIncomeId() { return incomeId; }
    public void setIncomeId(int incomeId) { this.incomeId = incomeId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
