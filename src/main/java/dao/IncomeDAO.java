package dao;

import model.Income;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {

    public void addIncome(Income income) {
        String sql = "INSERT INTO income(user_id, amount, category, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, income.getUserId());
            stmt.setDouble(2, income.getAmount());
            stmt.setString(3, income.getCategory());
            stmt.setDate(4, Date.valueOf(income.getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Income> getIncomesByUser(int userId) {
        List<Income> incomes = new ArrayList<>();
        String sql = "SELECT * FROM income WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Income income = new Income(
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getDate("date").toLocalDate()
                );
                income.setIncomeId(rs.getInt("income_id"));
                incomes.add(income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incomes;
    }
}
