package dao;

import model.Expense;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses(user_id, amount, category, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, expense.getUserId());
            stmt.setDouble(2, expense.getAmount());
            stmt.setString(3, expense.getCategory());
            stmt.setDate(4, Date.valueOf(expense.getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expense> getExpensesByUser(int userId) {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getDate("date").toLocalDate()
                );
                expense.setExpenseId(rs.getInt("expense_id"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
