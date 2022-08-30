package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        primaryStage.setTitle("Communication between multiple controllers");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
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
}
