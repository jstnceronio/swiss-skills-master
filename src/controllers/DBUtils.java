package controllers;

import controllers.dto.Inventory;
import controllers.dto.Item;
import controllers.dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtils {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_system", "root", "root");
    }

    public static User getUser(String username, String password) {
        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
            psSelect.setString(1, username);
            psSelect.setString(2, password);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public static ObservableList<Inventory> getInventories(User user) {
        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try {
            Connection connection = getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM inventory WHERE user_fk = ?");
            psSelect.setInt(1, user.getId());
            ResultSet rs = psSelect.executeQuery();
            Inventory inventory;
            while (rs.next()) {
                inventory = new Inventory(
                        rs.getInt("inventory_id"),
                        rs.getInt("user_fk"),
                        rs.getInt("item_fk")
                );
                inventoryItems.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryItems;
    }

    public static Item getItem(int id) {
        Item item = null;
        try {
            Connection connection = getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM item WHERE item_id = ?");
            psSelect.setInt(1, id);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                item = new Item(
                        rs.getInt("item_id"),
                        rs.getString("name")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}
