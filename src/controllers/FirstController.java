package controllers;

import controllers.dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstController implements Initializable {

    public TextField txtUsername;
    public PasswordField txtPassword;
    public Label lblError;

    public void login(ActionEvent e) throws IOException {
        User user = DBUtils.getUser(txtUsername.getText(), txtPassword.getText());
        if (user != null) {
            Main m = new Main();
            m.setLogin(user);
        } else {
            lblError.setText("Please check your credentials");
        }
    }

    public void clear(ActionEvent e) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
