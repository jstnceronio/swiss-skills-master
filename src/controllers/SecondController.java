package controllers;

import controllers.dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {
    public Label lblWelcome;
    public ListView lvItems;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void setUser(User user) {
        this.user = user;
        lblWelcome.setText("Hello " + user.getUsername() + ", this is your inventory");
        initializeLogin();
    }

    private void initializeLogin() {
        DBUtils.getInventories(user).forEach(item ->
                lvItems.getItems().add(item.getItemFk())
        );
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void update(ActionEvent actionEvent) {
    }

    public void detail(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        Parent root = loader.load();

        SecondController secondController = loader.getController();
        secondController.setUser(user);

        Stage stg = new Stage();
        stg.setScene(new Scene(root));
        stg.setTitle("Inventory view");
        stg.show();
    }

    public void add(ActionEvent actionEvent) {
    }
}
