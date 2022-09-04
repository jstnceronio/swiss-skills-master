package controllers;

import controllers.dto.Inventory;
import controllers.dto.Item;
import controllers.dto.Table;
import controllers.dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtils {

    private static DbConfig config = new DbConfig(
            "com.mysql.cj.jdbc.Driver",
            "jdbc:mysql://localhost:3306/table_management",
            "root",
            "root");

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
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
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM item WHERE name = ?");
            psSelect.setInt(1, id);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                item = new Item(
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    public static Table getTable(int number) {
        Table table = null;
        try {
            Connection connection = getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM table WHERE number = ?");
            psSelect.setInt(1, number);
            ResultSet rs = psSelect.executeQuery();
            if (rs.next()) {
                table = new Table(
                        rs.getInt("number"),
                        rs.getInt("seats")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return table;
    }

    public static ObservableList<Table> getTables() {
        ObservableList<Table> tables = FXCollections.observableArrayList();
        try {
            Connection connection = getConnection();
            PreparedStatement psSelect = connection.prepareStatement("SELECT * FROM table");
            ResultSet rs = psSelect.executeQuery();
            Table table;
            while (rs.next()) {
                table = new Table(
                        rs.getInt("number"),
                        rs.getInt("seats")
                );
                tables.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public static void addTable(int number, int seats) {
        try {
            Connection connection = getConnection();
            PreparedStatement psInsert = connection.prepareStatement(
                    "INSERT INTO table VALUES (?, ?)"
            );
            psInsert.setInt(1, number);
            psInsert.setInt(2, seats);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
