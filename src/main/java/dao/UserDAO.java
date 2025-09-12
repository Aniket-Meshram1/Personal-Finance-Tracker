package dao;

import model.User;
import util.DBConnection;

import java.sql.*;

public class UserDAO {

    public void registerUser(User user) {
        String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUserId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                user.setUserId(rs.getInt("user_id"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // login failed
    }
}
