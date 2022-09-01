package controllers;

import controllers.dto.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        stg.setTitle("Communication between multiple controllers");
        stg.setScene(new Scene(root));
        stg.show();
    }

    /**
     * Add vm option
     *  --module-path "E:\libraries\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml,javafx.media
     * Alt+V if vm options are not displayed
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void setLogin(User loggedInUser) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        Parent pane = loader.load();

        SecondController secondController = loader.getController();
        secondController.setUser(loggedInUser);
        stg.getScene().setRoot(pane);
    }
}
