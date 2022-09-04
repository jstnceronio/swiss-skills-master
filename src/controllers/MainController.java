package controllers;


import controllers.dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Label lblUser;
    public ListView tvTables;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tvTables.setItems(DBUtils.getTables());
    }

    public void setUser(User user) {
        this.user = user;
        lblUser.setText("|   " + user.getUsername());
        initializeLogin();
    }

    /**
     * User has been set, data can get filled
     */
    private void initializeLogin() {

    }

    public void addTable(ActionEvent actionEvent) {

    }
}
